package com.zking.ssm.controller;

import com.zking.ssm.model.Notice;
import com.zking.ssm.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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




}
