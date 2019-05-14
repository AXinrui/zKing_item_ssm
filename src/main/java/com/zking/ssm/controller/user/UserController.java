package com.zking.ssm.controller.user;

import com.zking.ssm.model.User;
import com.zking.ssm.service.IPropertyService;
import com.zking.ssm.service.IUserService;
import com.zking.ssm.utils.PageBean;
import com.zking.ssm.vo.UserVo;
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
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @Autowired
    private IPropertyService iPropertyService;

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
        u.setIid(1);
        u.setUstatus(1);
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
    public String userLogin(User u, HttpSession session){
        System.out.println(u);
        String returnValue = "";
        String login = iUserService.doLogin(u);
        System.out.println(login);
        if (login.equals("登录成功")){
            User user1 = iUserService.loadByUsername(u);
            user1.setProperty(iPropertyService.selectByPrimaryKey(user1.getPid()));
            session.setAttribute("user",user1);
            returnValue = "redirect:/zking/zking.shtml";
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
        user.setIid(1);
        user.setUid(1);
        PageBean pageBean = new PageBean();
        pageBean.setRows(5);
        pageBean.setRequest(request);
        List<User> userList = iUserService.listUser(user, pageBean);
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
        List<User> userList = iUserService.listUser(user, pageBean);
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

    //判断短信验证码
    @RequestMapping(value = "isVerificationCodeLogin")
    public void isVerificationCodeLogin(User u, HttpSession session, String userVerificationCode, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        System.out.println("用户输入验证码：" + userVerificationCode);
        String verificationCode = (String)session.getAttribute("verificationCode");
        System.out.println("系统验证码：" + verificationCode);
        System.out.println("判断结果：" + userVerificationCode.equals(verificationCode));
        if(userVerificationCode.equals(verificationCode)){
            User user1 = iUserService.selectByUphone(u);
            user1.setProperty(iPropertyService.selectByPrimaryKey(user1.getPid()));
            session.setAttribute("user",user1);
            System.out.println("验证码效验正确！");
            out.print("1");
        } else{
            System.out.println("验证码效验错误！");
            out.print("0");
        }
    }

    @RequestMapping("/toUserCenter")
    public String toUserCenter(){
        return "user/user_center";
    }

    @RequestMapping("/toPerfectInformaction")
    public String toPerfectInformaction(){
        return "user/perfect_information";
    }

    @RequestMapping("/toChangePassword")
    public String toChangePassword(){
        return "user/change_password";
    }

    @RequestMapping("/isUserPassword")
    public void isUserPassword(User u, HttpSession session,HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        boolean b = iUserService.getUserSaltPassword(u.getUpassword(),u.getUaccount());
        if(b){
            User user1 = iUserService.loadByUsername(u);
            user1.setProperty(iPropertyService.selectByPrimaryKey(user1.getPid()));
            session.setAttribute("user",user1);
            out.print("1");
        } else{
            out.print("0");
        }
    }

    @RequestMapping("/toUserRetrieve")
    public String toUserRetrieve(){
        return "user/user_retrieve";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User u,HttpSession session){
        //System.out.println(u);
        boolean b = iUserService.updateByPrimaryKeySelective(u);
        if (b == true){
            User user1 = iUserService.loadByUsername(u);
            user1.setProperty(iPropertyService.selectByPrimaryKey(user1.getPid()));
            session.setAttribute("user",user1);
            return "user/user_center";
        } else {
            return "user/perfect_information";
        }
    }

    @RequestMapping("/userExit")
    public String userExit(HttpSession session){
        session.setAttribute("user",null);
        return "user/user_login";
    }

    @RequestMapping("/Cancellation")
    public void Cancellation(User u, HttpSession session,HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        boolean b = iUserService.deleteByPrimaryKey(u.getUid());
        if(b){
            out.print("1");
        } else{
            out.print("0");
        }
    }

    @RequestMapping("/userExpressList")
    public ModelAndView userExpressList(String uname, HttpServletRequest request,ModelAndView modelAndView){
        User user = new User();
        if (null!= uname&&""!=uname) {
            user.setUname(uname);
        }
        user.setIid(2);
        PageBean pageBean = new PageBean();
        pageBean.setRows(5);
        pageBean.setRequest(request);
        List<User> userList = iUserService.listUser(user, pageBean);
        List<UserVo> userVos = new ArrayList<UserVo>();
        UserVo userVo = null;
        int start = 0;
        int end = 0;
        for (User user1 : userList) {
            userVo = new UserVo();
            user.setUid(user1.getUid());
            userVo.setUser(user1);
            user.setUname("正在派送中");
            start = iUserService.getUserExpressSum(user);
            user.setUname("派送完毕");
            end = iUserService.getUserExpressSum(user);
            userVo.setStart(start);
            userVo.setEnd(end);
            System.out.println(userVo.toString());
            userVos.add(userVo);
        }
        modelAndView.setViewName("admin/user_express_list");
        modelAndView.addObject("userVo",userVos);
        modelAndView.addObject(pageBean);
        return modelAndView;
    }

    @RequestMapping("/userRetrieve")
    public String userRetrieve(User u){
        System.out.println(u);
        User user = iUserService.loadByUsername(u);
        System.out.println("通过电话得到的用户："+user);
        boolean b = iUserService.updateByPrimaryKeySelective(user);
        if(b){
            return "user/user_login";
        }else{
            return "user/user_retrieve";
        }
    }

    @RequestMapping("/userExpEdit")
    public void userExpEdit(String id,HttpServletResponse response)throws IOException {
        PrintWriter out = response.getWriter();
        User user = new User();
        boolean b = false;
        user.setUid(Integer.parseInt(id));
        user.setIid(2);
        b = iUserService.updateByPrimaryKeySelective(user);
        if (b) out.print("1");else out.print("0");
    }

}
