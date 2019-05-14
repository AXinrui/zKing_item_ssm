package com.zking.ssm.controller.admin;

import com.zking.ssm.utils.Aute;
import com.zking.ssm.utils.PropertiesFile;
import com.zking.ssm.vo.EmailVo;
import com.zking.ssm.vo.MapVo;
import com.zking.ssm.vo.NoteVo;
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

        return "admin/order_view";
    }

    @RequestMapping("/doAdminEdit")
    public String doAdminEdit(){
        return "admin/admin_edit";
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
        String realPath = request.getSession().getServletContext().getRealPath("/properties/ditu.properties");
        Map<String, Object> map = PropertiesFile.inputFile(realPath);
        MapVo mapVo = new MapVo();
        mapVo.setTitle(map.get("title")+"");
        mapVo.setContent(map.get("content")+"");
        mapVo.setX(map.get("x")+"");
        mapVo.setY(map.get("y")+"");
        mapVo.setAddress(map.get("address")+"");
        mapVo.setPhone(map.get("phone")+"");
        mapVo.setEamil(map.get("eamil")+"");
        modelAndView.addObject("mapVo",mapVo);
        modelAndView.setViewName("/admin/map_set");
        return modelAndView;
    }

    @RequestMapping("/doMap")
    public ModelAndView doMap(HttpServletRequest request,ModelAndView modelAndView)throws Exception{
        String realPath = request.getSession().getServletContext().getRealPath("/properties/ditu.properties");
        Map<String, Object> map = PropertiesFile.inputFile(realPath);
        MapVo mapVo = new MapVo();
        mapVo.setX(map.get("x")+"");
        mapVo.setY(map.get("y")+"");
        mapVo.setTitle(map.get("title")+"");
        mapVo.setContent(map.get("content")+"");
        modelAndView.addObject("mapVo",mapVo);
        modelAndView.setViewName("/frontEnd/map");
        return modelAndView;
    }

    @RequestMapping("/setMap")
    public String setMap(MapVo mapVo, HttpServletRequest request, HttpSession session)throws Exception{
        String realPath = request.getSession().getServletContext().getRealPath("/properties/ditu.properties");
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
        String realPath = request.getSession().getServletContext().getRealPath("/properties/ditu.properties");
        Map<String, Object> map = PropertiesFile.inputFile(realPath);
        MapVo mapVo = new MapVo();
        mapVo.setAddress(map.get("address")+"");
        mapVo.setPhone(map.get("phone")+"");
        mapVo.setEamil(map.get("eamil")+"");
        modelAndView.addObject("mapVo",mapVo);
        modelAndView.setViewName("/frontEnd/map");
        return modelAndView;
    }

    @RequestMapping("/emailList")
    public ModelAndView emailList(HttpServletRequest request,ModelAndView modelAndView)throws Exception{
        String realPath = request.getSession().getServletContext().getRealPath("/properties/mail.properties");
        EmailVo emailVo = new EmailVo();
        Map<String, Object> map = PropertiesFile.inputFile(realPath);
        emailVo.setTitle(map.get("title")+"");
        emailVo.setMail(map.get("mail")+"");
        emailVo.setPassword(map.get("password")+"");
        emailVo.setSmtphost(map.get("smtphost")+"");
        emailVo.setUsername(map.get("username")+"");
        modelAndView.addObject("emailVo",emailVo);
        modelAndView.setViewName("/admin/email_set");
        return modelAndView;
    }

    @RequestMapping("/setEmail")
    public String setEmail(EmailVo emailVo, HttpServletRequest request, HttpSession session)throws Exception{
        String realPath = request.getSession().getServletContext().getRealPath("/properties/mail.properties");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title",emailVo.getTitle());
        map.put("mail",emailVo.getMail());
        map.put("password",emailVo.getPassword());
        map.put("smtphost",emailVo.getSmtphost());
        map.put("username",emailVo.getUsername());
        int i = PropertiesFile.outputFile(realPath, map);
        return "redirect:/url/admin/emailList";
    }

    @RequestMapping("/setNote")
    public String setEmail(NoteVo noteVo, HttpServletRequest request, HttpSession session)throws Exception{
        String realPath = request.getSession().getServletContext().getRealPath("/properties/note.properties");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key",noteVo.getKey());
        map.put("url",noteVo.getUrl());
        map.put("tpl_value",noteVo.getTpl_value());
        map.put("tpl_id",noteVo.getTpl_id());
        int i = PropertiesFile.outputFile(realPath, map);
        return "redirect:/url/admin/noteList";
    }

    @RequestMapping("/noteList")
    public ModelAndView noteList(HttpServletRequest request,ModelAndView modelAndView)throws Exception{
        String realPath = request.getSession().getServletContext().getRealPath("/properties/note.properties");
//        String realPath = request.getSession().getServletContext().getRealPath("/properties/mail.properties");
        Map<String, Object> map = PropertiesFile.inputFile(realPath);
        NoteVo noteVo = new NoteVo();
        noteVo.setKey(map.get("key")+"");
        noteVo.setUrl(map.get("url")+"");
        noteVo.setTpl_value(map.get("tpl_value")+"");
        noteVo.setTpl_id(map.get("tpl_id")+"");
        modelAndView.addObject("note",noteVo);
        modelAndView.setViewName("/admin/note_set");
        return modelAndView;
    }


}
