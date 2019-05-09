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


}
