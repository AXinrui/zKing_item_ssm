package com.zking.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
public class IndexController {

    @RequestMapping(value = "/zking/zking.shtml")
    public String toIndex(){
        return "admin/index";
    }

    @RequestMapping(value ={"/admin/login","/admin","/admin/login.html"} )
    public String toAdmin(){
        return "admin/login";
    }

    @RequestMapping(value = "/404")
    public String noResponse(){
        return "404";
    }

    @RequestMapping(value = "/i18n")
    public String toI18n(String locale, HttpSession session){

        if (locale.equals("zh")){
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.CHINA);
        }else {
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,Locale.US);
        }
        return "index";
    }

}
