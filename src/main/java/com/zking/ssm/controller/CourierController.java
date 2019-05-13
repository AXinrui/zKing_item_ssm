package com.zking.ssm.controller;

import com.zking.ssm.model.CourierSonUser;
import com.zking.ssm.model.CourierUser;
import com.zking.ssm.service.ICourierSonUserService;
import com.zking.ssm.service.ICourierUserService;
import com.zking.ssm.utils.PageBean;
import com.zking.ssm.vo.CourierUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RequestMapping("/courierUser")
@Controller
public class CourierController  {

    @Autowired
    private  ICourierUserService iCourierUserService;

    @RequestMapping("/courierUserList")
    public ModelAndView courierUserList(ModelAndView modelAndView, HttpServletRequest request, CourierUserVo courierUserVo){
        PageBean pageBean = new PageBean();
        pageBean.setRows(5);
        pageBean.setRequest(request);
        List<CourierUser> courierUserList = iCourierUserService.listCourierUser(courierUserVo, pageBean);
        modelAndView.addObject(pageBean);
        modelAndView.addObject("string1",courierUserVo.getString1());
        modelAndView.addObject("string2",courierUserVo.getString2());
        modelAndView.addObject(courierUserList);
        modelAndView.setViewName("admin/order_courier");
        return modelAndView;
    }

    @RequestMapping("/courierUserDel")
    public void delExpress(String id,HttpServletResponse response)throws IOException {
        PrintWriter out = response.getWriter();
        boolean b = false;
        try {
            int toid = 0;
            toid = Integer.parseInt(id);
            iCourierUserService.deleteByPrimaryKey(toid);
            b = iCourierUserService.deleteByPrimaryKey(toid)>0?true:false;
            if(b) out.print("1");else out.print("0");
        }catch (Exception e){
            //System.out.println("转型异常----执行以下方法");
            String[] split = id.split(",");
            for (int i=0;i<split.length;i++){
                iCourierUserService.deleteByPrimaryKey(Integer.parseInt(split[i]));
                b = iCourierUserService.deleteByPrimaryKey(Integer.parseInt(split[i]))>0?true:false;
            }
            if(b) out.print("1");else out.print("0");
        }

    }

}
