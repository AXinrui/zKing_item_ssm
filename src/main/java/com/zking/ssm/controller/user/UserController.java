package com.zking.ssm.controller.user;

import com.zking.ssm.model.User;
import com.zking.ssm.service.IUserService;
import com.zking.ssm.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

    @RequestMapping("/userList")
    public ModelAndView userList(String uname, HttpServletRequest request,ModelAndView modelAndView){
        User user = new User();
        if (null!= uname&&""!=uname) {
            user.setUname(uname);
        }
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<User> userList = iUserService.userList(user, pageBean);
        modelAndView.setViewName("admin/user_list");
        modelAndView.addObject(userList);
        modelAndView.addObject(pageBean);
        return modelAndView;
    }

    @RequestMapping("/userListDel")
    public ModelAndView userListDel(String uname, HttpServletRequest request,ModelAndView modelAndView){
        User user = new User();
        if (null!= uname&&""!=uname) {
            user.setUname(uname);
        }
        user.setUstatus(3);
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<User> userList = iUserService.userList(user, pageBean);
        modelAndView.addObject(userList);
        modelAndView.addObject(pageBean);
        modelAndView.setViewName("admin/user_del");
        return modelAndView;
    }

    /**
     * 状态改变
     * @param id
     * @param status
     * @param response
     * @throws IOException
     */
    @RequestMapping("/userStatus")
    public void updateKey(String id,String status,HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        User user = new User();
        user.setUid(Integer.parseInt(id));
        user.setUstatus( Integer.parseInt(status));
        boolean b = iUserService.updateByPrimaryKeySelective(user);
        if(b) out.print("1");else out.print("0");
    }

    /**
     * 用户转到回收站
     * @param id
     * @param response
     * @throws IOException
     */
    @RequestMapping("/userStatusDel")
    public void userStatus(String id,HttpServletResponse response)throws IOException{
        PrintWriter out = response.getWriter();
        User user = new User();
        user.setUstatus(3);
        int toid = 0;
        boolean b = false;
        try {
            toid = Integer.parseInt(id);
            user.setUid(toid);
            b = iUserService.updateByPrimaryKeySelective(user);
            if(b) out.print("1");else out.print("0");
        }catch (Exception e){
            //System.out.println("转型异常----执行以下方法");
            String[] split = id.split(",");
            for (int i=0;i<split.length;i++){
                user.setUid(Integer.parseInt(split[i]));
                b = iUserService.updateByPrimaryKeySelective(user);
            }
            if(b) out.print("1");else out.print("0");
        }

    }


    @RequestMapping("/userDel")
    public void delUser(String id,HttpServletResponse response)throws IOException{
        PrintWriter out = response.getWriter();
        int toid = 0;
        boolean b = false;
        try {
             toid = Integer.parseInt(id);
             b = iUserService.deleteByPrimaryKey(toid);
             if(b) out.print("1");else out.print("0");
        }catch (Exception e){
            //System.out.println("转型异常----执行以下方法");
            String[] split = id.split(",");
            for (int i=0;i<split.length;i++){
                b = iUserService.deleteByPrimaryKey(Integer.parseInt(split[i]));
            }
            if(b) out.print("1");else out.print("0");
        }

    }

    @RequestMapping("/recoverUser")
    public void recoverUser(String id,HttpServletResponse response)throws IOException{
        PrintWriter out = response.getWriter();
        User user = new User();
        user.setUstatus(1);
        int toid = 0;
        boolean b = false;
        try {
            toid = Integer.parseInt(id);
            user.setUid(toid);
            b = iUserService.updateByPrimaryKeySelective(user);
            if(b) out.print("1");else out.print("0");
        }catch (Exception e){
            //System.out.println("转型异常----执行以下方法");
            String[] split = id.split(",");
            for (int i=0;i<split.length;i++){
                user.setUid(Integer.parseInt(split[i]));
                b = iUserService.updateByPrimaryKeySelective(user);
            }
            if(b) out.print("1");else out.print("0");
        }

    }


}