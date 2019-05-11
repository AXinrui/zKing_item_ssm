package com.zking.ssm.controller.admin;

import com.zking.ssm.utils.Aute;
import com.zking.ssm.utils.PropertiesFile;
import com.zking.ssm.vo.EmailVo;
import com.zking.ssm.vo.MapVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/url/admin")
public class UrlController {

    @RequestMapping("/doWelcome")
    public String doWelcome(){
        return "admin/welcome";
    }

    @RequestMapping("/doIndex")
    public String doIndex(){
        return "admin/index";
    }

    @RequestMapping("/doUserList")
    public String doUserList(){
        return "admin/user_list";
    }

    @RequestMapping("/doOrderList")
    public String doOrderList(){
        return "admin/order_list";
    }

    @RequestMapping("/doOrderView")
    public String doOrderView(String name){
        System.out.println("name:-----"+name);

        return "admin/order_view";
    }

    @RequestMapping("/doUserExpressAdd")
    public String doUserExpressAdd(){
        return "admin/member_add";
    }

    @RequestMapping("/doGetMap")
    public String doGetMap(){
        return "admin/map";
    }

    @RequestMapping("/mapList")
    public ModelAndView mapList(HttpServletRequest request,ModelAndView modelAndView)throws Exception{
        String realPath = request.getRealPath("/properties/ditu.properties");
        Map<String, Object> map = PropertiesFile.inputFile(realPath);
        MapVo mapVo = new MapVo();
        mapVo.setTitle(PropertiesFile.getInputFile(realPath,"title"));
        mapVo.setContent(PropertiesFile.getInputFile(realPath,"content"));
        mapVo.setX(PropertiesFile.getInputFile(realPath,"x"));
        mapVo.setY(PropertiesFile.getInputFile(realPath,"y"));
        mapVo.setAddress(PropertiesFile.getInputFile(realPath,"address"));
        mapVo.setPhone(PropertiesFile.getInputFile(realPath,"phone"));
        mapVo.setEamil(PropertiesFile.getInputFile(realPath,"eamil"));
        modelAndView.addObject("mapVo",mapVo);
        modelAndView.setViewName("/admin/map_set");
        return modelAndView;
    }

    @RequestMapping("/doMap")
    public ModelAndView doMap(HttpServletRequest request,ModelAndView modelAndView)throws Exception{
        String realPath = request.getRealPath("/properties/ditu.properties");
        Map<String, Object> map = PropertiesFile.inputFile(realPath);
        MapVo mapVo = new MapVo();
        mapVo.setAddress(PropertiesFile.getInputFile(realPath,"address"));
        mapVo.setPhone(PropertiesFile.getInputFile(realPath,"phone"));
        mapVo.setEamil(PropertiesFile.getInputFile(realPath,"eamil"));
        modelAndView.addObject("mapVo",mapVo);
        modelAndView.setViewName("/frontEnd/map");
        return modelAndView;
    }

    @RequestMapping("/setMap")
    public String setMap(MapVo mapVo, HttpServletRequest request, HttpSession session)throws Exception{
        String realPath = request.getRealPath("/properties/ditu.properties");
        System.out.println("mapVo:"+mapVo.toString());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title",mapVo.getTitle());
        map.put("content",mapVo.getContent());
        map.put("x",mapVo.getX());
        map.put("y",mapVo.getY());
        map.put("address",mapVo.getAddress());
        map.put("phone",mapVo.getPhone());
        map.put("eamil",mapVo.getEamil());
        int i = PropertiesFile.outputFile(realPath, map);
        return "redirect:/url/admin/mapList";
    }

    @RequestMapping("/doData")
    public ModelAndView doData(HttpServletRequest request,ModelAndView modelAndView)throws Exception{
        String realPath = request.getRealPath("/properties/ditu.properties");
        Map<String, Object> map = PropertiesFile.inputFile(realPath);
        MapVo mapVo = new MapVo();
        mapVo.setAddress(PropertiesFile.getInputFile(realPath,"address"));
        mapVo.setPhone(PropertiesFile.getInputFile(realPath,"phone"));
        mapVo.setEamil(PropertiesFile.getInputFile(realPath,"eamil"));
        modelAndView.addObject("mapVo",mapVo);
        modelAndView.setViewName("/frontEnd/map");
        return modelAndView;
    }

    @RequestMapping("/emailList")
    public ModelAndView emailList(HttpServletRequest request,ModelAndView modelAndView)throws Exception{
        String realPath = request.getRealPath("/properties/mail.properties");
        Map<String, Object> map = PropertiesFile.inputFile(realPath);
        EmailVo emailVo = new EmailVo();
        emailVo.setTitle(PropertiesFile.getInputFile(realPath,"title"));
        emailVo.setMail(PropertiesFile.getInputFile(realPath,"mail"));
        emailVo.setPassword(PropertiesFile.getInputFile(realPath,"password"));
        emailVo.setSmtphost(PropertiesFile.getInputFile(realPath,"smtphost"));
        emailVo.setUsername(PropertiesFile.getInputFile(realPath,"username"));
        modelAndView.addObject("emailVo",emailVo);
        modelAndView.setViewName("/admin/email_set");
        return modelAndView;
    }

    @RequestMapping("/setEmail")
    public String setEmail(EmailVo emailVo, HttpServletRequest request, HttpSession session)throws Exception{
        String realPath = request.getRealPath("/properties/mail.properties");
        System.out.println("emailVo:"+emailVo.toString());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title",emailVo.getTitle());
        map.put("mail",emailVo.getMail());
        map.put("password",emailVo.getPassword());
        map.put("smtphost",emailVo.getSmtphost());
        map.put("username",emailVo.getUsername());
        int i = PropertiesFile.outputFile(realPath, map);
        return "redirect:/url/admin/email_set";
    }


}
