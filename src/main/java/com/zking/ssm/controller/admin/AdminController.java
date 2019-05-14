package com.zking.ssm.controller.admin;

import com.zking.ssm.model.Admin;
import com.zking.ssm.service.IAdminService;
import com.zking.ssm.utils.EmailUtil;
import com.zking.ssm.vo.AdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("/editAdmin")
    public ModelAndView editAdmin(AdminVO admin, ModelAndView modelAndView, HttpSession session){
        Admin a = (Admin) session.getAttribute("admin");
        if (a.getPassword().equals(admin.getYpwd())) {
            iAdminService.updateByPrimaryKey(admin);
            session.setAttribute("admin",iAdminService.selectByPrimaryKey(a.getAid()));
            modelAndView.addObject("abc","ok");
        }else{
            modelAndView.addObject("abc","no");
        }
        modelAndView.setViewName("/admin/admin_edit");
        return modelAndView;
    }

    @RequestMapping("/doAdminForget")
    public String doadminForget(){
        return "/admin/admin_forget";
    }

    @RequestMapping("/doyzm")
    public void doYzm(HttpSession session, HttpServletResponse response, String account, HttpServletRequest request)throws Exception{
        PrintWriter out = response.getWriter();
        try {
            Admin admin = iAdminService.loadAdmin(account);
            if (!account.equals(admin.getEmail())) {
                out.print("2");
            }else{
                String yzm = "";
                Random random = new Random();
                for (int i = 0;i<6;i++){
                    yzm += random.nextInt(9);
                }
                EmailUtil emailUtil = new EmailUtil();
                String realPath = request.getSession().getServletContext().getRealPath("/properties/mail.properties");
                emailUtil.init(realPath);
                boolean b = emailUtil.sendEmail(account, "这个一个验证码", "尊敬的管理员，您的验证码是(" + yzm + ")", null, null);
                if(b){
                    session.setAttribute("yzmAdmin",yzm);
                    out.print("1");
                }else{
                    out.print("0");
                }
            }
        }catch (Exception e){
            out.print("2");
        }

    }

    @RequestMapping("/yzm")
    public void yzm(String yzm,String account,HttpSession session,HttpServletResponse response) throws IOException{
        PrintWriter out = response.getWriter();
        String yzmAdmin = (String )session.getAttribute("yzmAdmin");
        Admin admin = iAdminService.getAdmin(account);
        if (admin!=null) {
            if(yzmAdmin.equals(yzm)){
                out.print("1");
            }else{
                out.print("0");
            }
        }else{
            out.print("2");
        }

    }

    @RequestMapping("/adminForget")
    @ResponseBody
    public String adminForget(String account,String password){
        System.out.println("admin"+account);
        Admin a = iAdminService.getAdmin(account);
        a.setPassword(password);
        int b = iAdminService.updateByPrimaryKeySelective(a);
        System.out.println("b------------"+b);
        if (b>0) {
            return "1";
        }else{
            return "0";
        }
    }

    @RequestMapping("/doPassword")
    public ModelAndView doPassword(String account,HttpServletResponse response,ModelAndView modelAndView) throws IOException{
        modelAndView.setViewName("/admin/admin_password");
        modelAndView.addObject("account",account);
        return modelAndView;
    }

}
