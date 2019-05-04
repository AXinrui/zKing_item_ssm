package com.zking.ssm.controller;

import com.zking.ssm.model.Admin;
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

    @RequestMapping(value = "/doLogin")
     public void login(@RequestBody(required=true) Map<String,Object> map){
        String account = map.get("account").toString();
        String password = map.get("password").toString();
        String huadong = map.get("huadong").toString();


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
        out.print(yzm);
    }


}
