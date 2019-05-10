package com.zking.ssm.controller.frontEnd;

import com.zking.ssm.model.Express;
import com.zking.ssm.model.Message;
import com.zking.ssm.service.IMessageService;
import com.zking.ssm.utils.EmailUtil;
import com.zking.ssm.utils.PageBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
    @RequestMapping("/messageList")
    public ModelAndView expressCourierList(Message message, HttpServletRequest request, ModelAndView modelAndView){
        PageBean pageBean = new PageBean();
        pageBean.setRows(5);
        pageBean.setRequest(request);
        List<Message> messageList = iMessageService.listMessage(message, pageBean);
        modelAndView.setViewName("admin/message_list");
        modelAndView.addObject("messageLists",messageList);
        modelAndView.addObject("pageBean",pageBean);
        modelAndView.addObject("mname",message.getMname());
        return modelAndView;
    }

    @RequestMapping("/messageDel")
    public void messageDel(String id,HttpServletResponse response)throws IOException {
        PrintWriter out = response.getWriter();
        int toid = 0;
        boolean b = false;
        try {
            toid = Integer.parseInt(id);
            b = iMessageService.deleteByPrimaryKey(toid)>0?true:false;
            if(b) out.print("1");else out.print("0");
        }catch (Exception e){
            //System.out.println("转型异常----执行以下方法");
            String[] split = id.split(",");
            for (int i=0;i<split.length;i++){
                b = iMessageService.deleteByPrimaryKey(Integer.parseInt(split[i]))>0?true:false;
            }
            if(b) out.print("1");else out.print("0");
        }

    }

    @RequestMapping("/messageReply")
    public void messageReply(Message message,HttpServletResponse response,HttpServletRequest request)throws IOException {
        PrintWriter out = response.getWriter();
        System.out.println("message"+message.toString());
        boolean b = false;
        try {
            EmailUtil emailUtil = new EmailUtil(request.getRealPath("/properties/mail.properties"));
            b = emailUtil.sendEmail(message.getMphone(), null, message.getMcontent(), null, null);
            System.out.println("b-----------：：："+b);
            if (b) {
                message.setMcontent(null);
                message.setMstatus(0);
                b = iMessageService.updateByPrimaryKeySelective(message)>0?true:false;
                if(b) out.print("1");else out.print("0");
            }
        }catch (Exception e){
            //System.out.println("转型异常----执行以下方法");
             out.print("0");
        }
    }


}
