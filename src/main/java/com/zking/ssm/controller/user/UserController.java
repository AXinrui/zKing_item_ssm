package com.zking.ssm.controller.user;

import com.zking.ssm.model.User;
import com.zking.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @ModelAttribute
    public void init(Model model){
        User user = new User();
        model.addAttribute("user",user);
    }

    /*//发送短信验证码
    @RequestMapping(value = "sendVerificationCode")
    public void sendVerificationCode(User u, HttpSession session){
        String verificationCode = Aute.mobileQuery(u.getUphone());
        session.setAttribute("verificationCode",verificationCode);
        System.out.println("验证码：" + verificationCode);
        System.out.println("用户：" + u);
    }*/

    @RequestMapping(value = "sendVerificationCode")
    public void sendVerificationCode(User u, HttpSession session){
        String verificationCode = "888888";
        session.setAttribute("verificationCode",verificationCode);
        System.out.println("验证码：" + verificationCode);
        System.out.println("用户：" + u);
    }

    //判断短信验证码
    @RequestMapping(value = "isVerificationCode")
    public void isVerificationCode(User u, HttpSession session, String userVerificationCode, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        System.out.println("用户输入验证码：" + userVerificationCode);
        String verificationCode = (String)session.getAttribute("verificationCode");
        System.out.println("系统验证码：" + verificationCode);
        System.out.println("判断结果：" + userVerificationCode.equals(verificationCode));
        if(userVerificationCode.equals(verificationCode)){
            System.out.println("验证码效验正确！");
            out.print("1");
        } else{
            System.out.println("验证码效验错误！");
            out.print("0");
        }
    }


    @RequestMapping(value = "/toUserRegister")
    public String toUserRegister(){
        return "user/user_register";
    }

    @RequestMapping(value = "/userRegister")
    public String userRegister(User u){
        String returnValue = "";
        u.setUaccount(u.getUphone());
        System.out.println("注册用户1："+ u);
        int i = iUserService.doRegister(u);
        System.out.println("注册用户2："+ u);

        if (i > 0) {
            returnValue = "user/user_login";
        } else {
            returnValue = "user/user_register";
        }

        return returnValue;
    }

    @RequestMapping(value = "/toUserLogin")
    public String toUserLogin(){
        return "user/user_login";
    }

    @RequestMapping(value = "/userLogin")
    public String userLogin(User u){
        System.out.println(u);
        String returnValue = "";
            String login = iUserService.doLogin(u);
            System.out.println(login);
            if (login.equals("登录成功")){
                returnValue = "index";
            }
            if (login.equals("帐号已锁定，请与管理员联系")){
                returnValue = "user/user_login";
            }

        return returnValue;
    }


}
