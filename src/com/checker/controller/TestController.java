package com.checker.controller;

import com.checker.entity.Dept;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET, params = "user")
    public String test() {
        System.out.println("testController方法调用");
        return "success";
    }

    @RequestMapping("/testAnt/*")
    public String testAnt() {
        System.out.println("testAnt...");
        return "success";
    }

    @RequestMapping("/testParam")
    public String testParam(@RequestParam(value = "value",
            required = false,
            defaultValue = "-1") int val) {
        System.out.println("TestParam..." + val);
        return "success";
    }

    @RequestMapping("/testCharset")
    public String testCharset(Dept dept) {
        System.out.println("testCharset..." + dept);
        return "success";
    }

    @RequestMapping("/testForward")
    public String testForward(){
        System.out.println("testForward...");
        return "forward:/forward.jsp";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect(){
        System.out.println("testForward...");
        return "redirect:/redirect.jsp";
    }

}

