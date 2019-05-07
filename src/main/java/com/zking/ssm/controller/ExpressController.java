package com.zking.ssm.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.zking.ssm.model.Express;
import com.zking.ssm.service.IExpressService;
import com.zking.ssm.utils.PageBean;
import com.zking.ssm.utils.TransitionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/express")
public class ExpressController {

    @Autowired
    private IExpressService iExpressService;

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

    @RequestMapping(value = "/orderOnline")
    public String orderOnline(Express express){
        boolean b = iExpressService.insertSelective(express);
        if (b == true){
            return "";
        } else {
            return "";
        }
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


}
