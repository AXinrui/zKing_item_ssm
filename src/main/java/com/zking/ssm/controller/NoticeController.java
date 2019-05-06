package com.zking.ssm.controller;

import com.zking.ssm.model.Dict;
import com.zking.ssm.model.Notice;
import com.zking.ssm.service.INoticeService;
import com.zking.ssm.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/notice")
public class NoticeController {

    @Autowired
    private INoticeService iNoticeService;

    @ModelAttribute
    public void init(Model model){
        Notice notice = new Notice();
        model.addAttribute("notice",notice);
    }

    @RequestMapping(value = "/noticeList")
    public ModelAndView noticeList(Notice n, ModelAndView modelAndView, HttpServletRequest request){

        PageBean pageBean = new PageBean();

        List<Notice> listNotice = iNoticeService.listNotice(n, pageBean);

        modelAndView.addObject("pageBean",pageBean);
        modelAndView.addObject("listNotice",listNotice);

        //modelAndView.setViewName("sys/listBook");

        return modelAndView;
    }




}
