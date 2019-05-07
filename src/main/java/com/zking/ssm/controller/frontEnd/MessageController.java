package com.zking.ssm.controller.frontEnd;

import com.zking.ssm.model.Message;
import com.zking.ssm.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/message")
public class MessageController {

    @Autowired
    private IMessageService iMessageService;

    @ModelAttribute
    public void init(Model model){
        Message m = new Message();
        model.addAttribute("message",m);
    }

    @RequestMapping(value = "/solution")
    public String solution(Message message){
        System.out.println(message);
        int i = iMessageService.insertSelective(message);
        if(i > 0){
            return "frontEnd/messageSuccess";
        }else{
            return "frontEnd/solution";
        }
    }



}
