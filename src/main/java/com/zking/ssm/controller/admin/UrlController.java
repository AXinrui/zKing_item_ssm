package com.zking.ssm.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
