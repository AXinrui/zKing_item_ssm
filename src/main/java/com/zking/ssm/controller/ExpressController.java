package com.zking.ssm.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.sun.deploy.net.HttpResponse;
import com.zking.ssm.model.Express;
import com.zking.ssm.model.Property;
import com.zking.ssm.model.User;
import com.zking.ssm.service.IExpressService;
import com.zking.ssm.service.IPropertyService;
import com.zking.ssm.service.IUserService;
import com.zking.ssm.utils.Aute;
import com.zking.ssm.utils.PageBean;
import com.zking.ssm.utils.TransitionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/express")
public class ExpressController {

    @Autowired
    private IExpressService iExpressService;

    @Autowired
    private IPropertyService iPropertyService;

    @RequestMapping("/expressList")
    public ModelAndView expressList(Express express,String dateOne,String dateTwo, HttpServletRequest request, ModelAndView modelAndView){
        System.out.println("expresss:-------"+express.toString());
        PageBean pageBean = new PageBean();
        pageBean.setRows(5);
        pageBean.setRequest(request);
        if (dateOne!=null&&""!=dateOne&&dateTwo!=null&&""!=dateTwo) {
            express.setShippertime(TransitionUtil.getDate(dateOne,1));
            express.setConsigneetime(TransitionUtil.getDate(dateTwo,2));
        }
        List<Express> expressList = iExpressService.listExpress(express, pageBean);
        System.out.println("expressList:"+expressList.size());
        modelAndView.setViewName("admin/order_list");
        modelAndView.addObject(expressList);
        modelAndView.addObject("pageBean",pageBean);
        modelAndView.addObject("orderId",express.getOrderid());
        return modelAndView;
    }

    @RequestMapping(value = "/expressGet",method = RequestMethod.GET)
    public ModelAndView expressGet(ModelAndView modelAndView,String name){
        String[] split = name.split(",");
        Express express = iExpressService.selectByPrimaryKey(Integer.parseInt(split[0]));
        modelAndView.addObject(express);
        modelAndView.addObject("status",split[1]);
        modelAndView.setViewName("admin/order_view");
        return modelAndView;
    }

    @RequestMapping(value = "/toOrderOnline")
    public String toOrderOnline(Express express){return "frontEnd/orderOnline";}

    @RequestMapping(value = "getLongitudeAndLatitude")
    @ResponseBody
    public String getLongitudeAndLatitude(String address){
        String longitudeAndLatitude = Aute.getLongitudeAndLatitude(address);
        System.out.println("longitudeAndLatitude: "+longitudeAndLatitude);
        return longitudeAndLatitude;
    }

    @RequestMapping(value = "/orderOnline")
    public String orderOnline(Express express, HttpSession session, HttpServletRequest request){
        User user = (User)session.getAttribute("user");

        express.setUid(user.getUid());
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        String orderId = "33067529" + df.format(new Date());// new Date()为获取当前系统时间
        express.setOrderid(orderId);


        System.out.println(express);

        if(user.getProperty().getPbalance() < express.getOrderprice()){
            express.setEsid(7);
            boolean b = iExpressService.insertSelective(express);
            if (b == true){
                return "frontEnd/balance_insufficient";
            } else {
                return "frontEnd/orderOnline";
            }
        }else{
            express.setEsid(7);
            boolean b = iExpressService.insertSelective(express);
            if (b == true){
                request.setAttribute("eid",express.getEid());
                request.setAttribute("price",express.getOrderprice());
                return "frontEnd/payment";
            } else {
                return "frontEnd/orderOnline";
            }
        }
    }

    @RequestMapping("/payment")
    public void payment(Express express,Float price, HttpServletResponse response, HttpSession session) throws Exception {

        User user = (User)session.getAttribute("user");
        Property property = user.getProperty();
        property.setPbalance(price);
        iPropertyService.updateByPrimaryKeySelective(property);

        PrintWriter out = response.getWriter();
        express.setEsid(1);
        boolean b = iExpressService.updateByPrimaryKeySelective(express);
        if(b){
            out.print("1");
        } else{
            out.print("0");
        }
    }

    @RequestMapping("/pendingPayment")
    public void pendingPayment(Express express,Float price, HttpServletResponse response, HttpSession session) throws Exception {

        User user = (User)session.getAttribute("user");
        float fprice = user.getProperty().getPbalance() - price;
        Property property = user.getProperty();
        property.setPbalance(fprice);
        iPropertyService.updateByPrimaryKeySelective(property);

        PrintWriter out = response.getWriter();
        express.setEsid(1);
        boolean b = iExpressService.updateByPrimaryKeySelective(express);
        if(b){
            out.print("1");
        } else{
            out.print("0");
        }
    }

    @RequestMapping("/toBalanceInsufficient")
    public String toBalanceInsufficient() {
        return "frontEnd/balance_insufficient";
    }

    @RequestMapping("/expressDel")
    public void delExpress(String id,HttpServletResponse response)throws IOException {
        PrintWriter out = response.getWriter();
        int toid = 0;
        boolean b = false;
        try {
            toid = Integer.parseInt(id);
            b = iExpressService.deleteByPrimaryKey(toid);
            if(b) out.print("1");else out.print("0");
        }catch (Exception e){
            //System.out.println("转型异常----执行以下方法");
            String[] split = id.split(",");
            for (int i=0;i<split.length;i++){
                b = iExpressService.deleteByPrimaryKey(Integer.parseInt(split[i]));
            }
            if(b) out.print("1");else out.print("0");
        }

    }

    @RequestMapping("/expressCourierList")
    public ModelAndView expressCourierList(String esid, HttpServletRequest request, ModelAndView modelAndView){
        System.out.println("expresss:-------"+esid.toString());
        Express express = new Express();
        express.setEsid(Integer.parseInt(esid.split(",")[0]));
        PageBean pageBean = new PageBean();
//        pageBean.setRows(10);
        pageBean.setRequest(request);
        List<Express> expressList = iExpressService.listExpress(express, pageBean);
        System.out.println("expressList:"+expressList.size());
        modelAndView.setViewName("admin/courier_detail");
        modelAndView.addObject("expressLists",expressList);
        modelAndView.addObject("uid",esid.split(",")[1]);
        modelAndView.addObject("pageBean",pageBean);
        return modelAndView;
    }

    @RequestMapping("/myLogistics")
    public ModelAndView myLogistics(Express express, HttpServletRequest request, ModelAndView modelAndView){
        System.out.println("expresss:-------"+express.toString());
        PageBean pageBean = new PageBean();
        pageBean.setRows(5);
        pageBean.setRequest(request);
        List<Express> expressList = iExpressService.listExpress(express, pageBean);
        System.out.println("expressList:"+expressList.size());
        modelAndView.addObject("expressList",expressList);
        modelAndView.addObject("pageBean",pageBean);
        modelAndView.addObject("orderId",express.getOrderid());

        if(express.getEsid() == 7){
            modelAndView.setViewName("user/myLogistics_pending_payment");
        } else if(express.getEsid() == 5){
            modelAndView.setViewName("user/myLogistics_received_goods");
        } else{
            modelAndView.setViewName("user/myLogistics_deliver");
        }

        return modelAndView;
    }

    /**
     * 问题啊  的
     */
    @RequestMapping("/doExpressSelect")
    public String doExpressSelect(){
        return "/frontEnd/express_sel";
    }

    /**
     * 问题啊
     * @param express
     * @return
     */
    @RequestMapping("/expressSelect")
    @ResponseBody
    public List<Express> expressSelect(Express express){
        String content = express.getOrderid();
        express.setOrderid(null);
        System.out.println("content："+content);
        List<Express> expresses = new ArrayList<Express>();
        if (content.length()<=11) {
            express.setShipperphone(content);
        }else{
            express.setOrderid(content);
        }
        System.out.println("express:"+express.toString());
        express = iExpressService.selectExpress(express);
        expresses.add(express);
        return expresses;
    }


}
