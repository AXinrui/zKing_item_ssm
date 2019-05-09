package com.zking.ssm.controller;

import com.zking.ssm.model.CourierSonUser;
import com.zking.ssm.model.CourierUser;
import com.zking.ssm.model.Express;
import com.zking.ssm.service.ICourierSonUserService;
import com.zking.ssm.service.ICourierUserService;
import com.zking.ssm.service.IExpressService;
import com.zking.ssm.utils.PageBean;
import com.zking.ssm.vo.CourierUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RequestMapping("/courier")
@Controller
public class CourierUserController {

    @Autowired
    private ICourierUserService iCourierUserService;
    @Autowired
    private ICourierSonUserService iCourierSonUserService;
    @Autowired
    private IExpressService iExpressService;


    /**
     * 快递员订单详细增加
     * @param id
     * @param uid
     * @param response
     * @throws IOException
     */
    @RequestMapping("/orderCourierAdd")
    public void orderCourierAdd(String id,String uid,HttpServletResponse response)throws IOException{
        System.out.println("id---"+id+"-------"+uid);
        Express express = new Express();
        PrintWriter out = response.getWriter();
        CourierSonUser courierSonUser = new CourierSonUser();
        CourierUser courierUser = new CourierUser();
        courierUser.setUid(Integer.parseInt(uid));
        int toid = 0;
        boolean b = false;
        try {
            toid = Integer.parseInt(id);
                express.setEsid(3);
                List<Express> expressList = iExpressService.listExpress(express, null);
                if (expressList.size()<toid) {
                    out.print("2");
                }else{
                    boolean bl = iCourierUserService.insert(courierUser)>0?true:false;
                    courierSonUser.setCuid(courierUser.getCuid());
                    for (int i = 0; i < toid; i++) {
                        express = expressList.get(i);
                        courierSonUser.setEid(express.getEid());
                        b =  iCourierSonUserService.insert(courierSonUser)>0?false:true;
                        express.setEsid(6);
                        if (b) iExpressService.updateByPrimaryKeySelective(express);
                    }
                    if(b) out.print("1");else out.print("0");
                }
            }catch (Exception e){
//                System.out.println("转型异常----执行以下方法");
                boolean bl = iCourierUserService.insert(courierUser)>0?true:false;
                courierSonUser.setCuid(courierUser.getCuid());
                String[] split = id.split(",");
                for (int i=0;i<split.length;i++){
                    toid = Integer.parseInt(split[i]);
                    courierSonUser.setEid(toid);
                    b =  iCourierSonUserService.insert(courierSonUser)>0?true:false;
                    express.setEid(toid);
                    express.setEsid(6);
                    if (b) iExpressService.updateByPrimaryKeySelective(express);
                }
                if(b) out.print("1");else out.print("0");
            }
    }

    //订单详细list
    @RequestMapping("/courierSonUserList")
    public ModelAndView courierSonUserList(ModelAndView modelAndView, HttpServletRequest request, String id){
        PageBean pageBean = new PageBean();
        pageBean.setRows(5);
        pageBean.setRequest(request);
        CourierSonUser courierSonUser = new CourierSonUser();
        courierSonUser.setCuid(Integer.parseInt(id));
        System.out.println("courierUserLists--id:-----"+id);
        List<CourierSonUser> lists = iCourierSonUserService.listCourierSonUser(courierSonUser, pageBean);
        request.setAttribute("lists",lists);
        modelAndView.addObject("pageBean",pageBean);
        modelAndView.setViewName("admin/order_courier_detail");
        return modelAndView;
    }

    //删除订单详细里订单
    @RequestMapping("/courierSonUserDel")
    public void delcourierSonUser(String id,HttpServletResponse response)throws IOException {
        PrintWriter out = response.getWriter();
        int toid = 0;
        boolean b = false;
        try {
            toid = Integer.parseInt(id);
            b = iCourierSonUserService.deleteByPrimaryKey(toid)>0?true:false;
            if(b) out.print("1");else out.print("0");
        }catch (Exception e){
            //System.out.println("转型异常----执行以下方法");
            String[] split = id.split(",");
            for (int i=0;i<split.length;i++){
                b = iCourierSonUserService.deleteByPrimaryKey(Integer.parseInt(split[i]))>0?true:false;
            }
            if(b) out.print("1");else out.print("0");
        }

    }

}
