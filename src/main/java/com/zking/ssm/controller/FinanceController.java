package com.zking.ssm.controller;

import com.zking.ssm.model.Finance;
import com.zking.ssm.service.IFinanceService;
import com.zking.ssm.utils.PageBean;
import com.zking.ssm.vo.FinanceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/finance")
public class FinanceController {

       @Autowired
       private IFinanceService iFinanceService;

       @RequestMapping("/financeList")
       public ModelAndView financeList(ModelAndView modelAndView, HttpServletRequest request, FinanceVo financeVo){
           PageBean pageBean = new PageBean();
           pageBean.setRequest(request);
           List<Finance> finances = iFinanceService.listFinance(financeVo, pageBean);

           modelAndView.addObject("finances",finances);
           modelAndView.setViewName("");
           return modelAndView;
       }

}
