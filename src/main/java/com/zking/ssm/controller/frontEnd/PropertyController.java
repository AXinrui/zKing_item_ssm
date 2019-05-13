package com.zking.ssm.controller.frontEnd;

import com.zking.ssm.model.Property;
import com.zking.ssm.model.User;
import com.zking.ssm.service.IPropertyService;
import com.zking.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/property")
public class PropertyController {

    @Autowired
    private IPropertyService iPropertyService;

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/toOpenWallet")
    public String toOpenWallet(){
        return "user/open_wallet";
    }

    @RequestMapping(value = "/toAccountBalance")
    public String toAccountBalance(User user, HttpServletRequest request){
        Property property = iPropertyService.selectByPrimaryKey(user.getPid());
        request.setAttribute("property",property);
        return "user/account_balance";
    }

    @RequestMapping(value = "/toChangeTheTransactionPassword")
    public String toChangeTheTransactionPassword(User user, HttpServletRequest request){
        Property property = iPropertyService.selectByPrimaryKey(user.getPid());
        request.setAttribute("property",property);
        return "user/change_the_transaction_password";
    }

    @RequestMapping(value = "/openWallet")
    public String openWallet(Property property, User user, HttpSession session){
        property.setPbalance(0f);
        property.setPstatus(1);
        //System.out.println("property前:"+property);
        int insert = iPropertyService.insert(property);
        //System.out.println("property后:"+property);
        if(insert > 0){
            user.setPid(property.getPid());
            //System.out.println(user);
            boolean b = iUserService.updateByPrimaryKeySelective(user);
            if(b){
                User user1 = iUserService.loadByUsername(user);
                user1.setProperty(iPropertyService.selectByPrimaryKey(user1.getPid()));
                session.setAttribute("user",user1);
            }
            return "user/user_center";
        } else{
            return "redirect:toOpenWallet";
        }
    }

    @RequestMapping(value = "/updateProperty")
    public String updateProperty(Property property){
        int i = iPropertyService.updateByPrimaryKeySelective(property);
        if(i > 0){
            return "user/user_center";
        } else{
            return "redirect:toChangeTheTransactionPassword";
        }
    }

    @RequestMapping(value = "toRecharge")
    public String toRecharge(User user, HttpServletRequest request){
        Property property = iPropertyService.selectByPrimaryKey(user.getPid());
        request.setAttribute("property",property);
        return "user/recharge";
    }

    @RequestMapping(value = "recharge")
    public String recharge(Property property){
        int i = iPropertyService.updateByPrimaryKeySelective(property);
        return "user/user_center";
    }

}
