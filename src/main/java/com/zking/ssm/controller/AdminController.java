package com.zking.ssm.controller;

import com.zking.ssm.model.Admin;
import com.zking.ssm.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService iAdminService;

    @RequestMapping(value = "/doLogin")
     public String login(@RequestBody(required=true) Map<String,Object> map,HttpSession session,HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String account = map.get("account").toString();
        String password = map.get("password").toString();
        String huadong = map.get("huadong").toString();
        Admin admin = new Admin();
        admin.setAccount(account);
        admin.setPassword(password);
        if (huadong.equals(session.getAttribute("huadong"))) {
            boolean login = iAdminService.login(admin);
            System.out.println("huadong-------:"+huadong+"------login---"+login);
            if (login==true) {
                out.print("1");
            }else{
                out.print("0");
                session.setAttribute("huadong",null);
            }
            return null;
        }else{
            return "404";
        }
     }


   @RequestMapping(value = "/yz")
    public void yzm(HttpSession session, HttpServletResponse response) throws IOException {
        Random random = new Random();
        PrintWriter out = response.getWriter();
        String yzm = "";
        for (int i =0;i<6;i++){
            yzm += random.nextInt(9);
        }
        session.setAttribute("huadong",yzm);
        session.setMaxInactiveInterval(120);
        out.print(yzm);
    }


}
