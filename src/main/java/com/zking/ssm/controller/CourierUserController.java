package com.zking.ssm.controller;

import com.zking.ssm.model.CourierSonUser;
import com.zking.ssm.model.CourierUser;
import com.zking.ssm.service.ICourierSonUserService;
import com.zking.ssm.service.ICourierUserService;
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


    @RequestMapping("/orderCourierAdd")
    public void orderCourierAdd(String id,String uid,HttpServletResponse response)throws IOException{
        PrintWriter out = response.getWriter();
        CourierUser courierUser = new CourierUser();
        courierUser.setUid(Integer.parseInt(uid));
        int toid = 0;
        boolean b = false;
        boolean bl = iCourierUserService.insert(courierUser)>0?true:false;
        if (bl) {
            CourierSonUser courierSonUser = new CourierSonUser();
            courierSonUser.setCuid(courierUser.getCuid());
            courierSonUser.setEid(toid);
            try {
                toid = Integer.parseInt(id);
                iCourierSonUserService.insertSelective(courierSonUser);
                if(b) out.print("1");else out.print("0");
            }catch (Exception e){
                //System.out.println("转型异常----执行以下方法");
                String[] split = id.split(",");
                for (int i=0;i<split.length;i++){
                    courierSonUser.setEid((Integer.parseInt(split[i])));
                    b =  iCourierSonUserService.insertSelective(courierSonUser)>0?true:false;
                }
                if(b) out.print("1");else out.print("0");
            }
        }

    }

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
