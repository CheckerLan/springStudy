package com.checker.controller;

import com.checker.dao.UserDAO;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

@Controller
public class ContextLoaderTestController {
    WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();

    @RequestMapping("/testContextLoader")
    public String testContextLoader(){
        UserDAO userDAO = context.getBean("userDAOImpl",UserDAO.class);
        userDAO.add();
        return "success";
    }
}
