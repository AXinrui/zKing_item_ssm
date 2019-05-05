package com.zking.ssm.controller.admin;

import com.zking.ssm.model.Admin;
import com.zking.ssm.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    /**
     * 登录的方法，保存admin的session
     * @param map
     * @param session
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
     public String login(@RequestBody(required=true) Map<String,Object> map,HttpSession session,HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String account = map.get("account")+"";
        String password = map.get("password")+"";
        String huadong = map.get("huadong")+"";
        Admin admin = new Admin();
        admin.setAccount(account);
        admin.setPassword(password);
        if (huadong.equals(session.getAttribute("huadong"))) {//在服务端判断滑块验证是否匹配
            boolean login = iAdminService.login(admin);//登录
            if (login==true) {//判断是否登录成功
                admin = iAdminService.getAdmin(account);
                session.setAttribute("admin",admin);
                out.print("1");
            }else{
                session.setAttribute("huadong",null);
                out.print("0");
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
        //session.setMaxInactiveInterval(120);
        out.print(yzm);
    }

}
