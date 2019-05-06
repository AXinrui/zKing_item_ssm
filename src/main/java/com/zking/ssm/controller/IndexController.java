package com.zking.ssm.controller;

import com.zking.ssm.model.Dict;
import com.zking.ssm.model.Notice;
import com.zking.ssm.service.IDictService;
import com.zking.ssm.service.INoticeService;
import com.zking.ssm.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

@Controller
public class IndexController {

    @Autowired
    private INoticeService iNoticeService;
    @Autowired
    private IDictService iDictService;

    @RequestMapping(value = "/zking/zking.shtml")
    private ModelAndView toIndexPreparationData(Notice notice, Dict dict, ModelAndView modelAndView, HttpServletRequest request){

        PageBean pageBean = new PageBean();

        List<Notice> listNotice = iNoticeService.listNotice(notice, pageBean);

        for (Notice notice1 : listNotice) {
            System.out.println(notice1);
        }

        List<Dict> listDict = iDictService.listDict(dict, pageBean);

        modelAndView.addObject("pageBean",pageBean);
        modelAndView.addObject("listNotice",listNotice);
        modelAndView.addObject("listDict",listDict);

        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value ={"/admin/login","/admin/login.html"} )
    public String toAdmin(){
        return "admin/login";
    }

//    @RequestMapping(value = "/")
//    public String noResponse(){
//        return "404";
//    }

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
