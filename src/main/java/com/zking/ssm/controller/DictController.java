package com.zking.ssm.controller;

import com.zking.ssm.service.IDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/dict")
public class DictController {

    @Autowired
    private IDictService iDictService;

}
