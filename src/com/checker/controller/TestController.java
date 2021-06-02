package com.checker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/test")
    public String test(){
        System.out.println("testController方法调用");
        return "/WEB-INF/pages/success.jsp";
    }

}

