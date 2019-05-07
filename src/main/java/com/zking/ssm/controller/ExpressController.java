package com.zking.ssm.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.zking.ssm.model.Express;
import com.zking.ssm.service.IExpressService;
import com.zking.ssm.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/express")
public class ExpressController {

    @Autowired
    private IExpressService iExpressService;

    @RequestMapping("/expressList")
    public ModelAndView expressList(Express express, HttpServletRequest request, ModelAndView modelAndView){
        PageBean pageBean = new PageBean();
        pageBean.setRows(5);
        pageBean.setRequest(request);
        List<Express> expressList = iExpressService.listExpress(express, pageBean);
        System.out.println("expressList:"+expressList.size());
        modelAndView.setViewName("admin/order_list");
        modelAndView.addObject(expressList);
        modelAndView.addObject("pageBean",pageBean);
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


}
