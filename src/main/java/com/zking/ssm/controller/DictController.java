package com.zking.ssm.controller;

import com.zking.ssm.model.Dict;
import com.zking.ssm.service.IDictService;
import com.zking.ssm.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/dict")
public class DictController {

    @Autowired
    private IDictService iDictService;

    //拿到所有数据字典
    @RequestMapping(value = "/dictList")
    public ModelAndView dictList(Dict d, ModelAndView modelAndView, HttpServletRequest request){

        PageBean pageBean = new PageBean();

        List<Dict> dictList = iDictService.listDict(d, pageBean);

        modelAndView.addObject("pageBean",pageBean);
        modelAndView.addObject("dictList",dictList);

        //modelAndView.setViewName("sys/listBook");

        return modelAndView;
    }

}
