package com.checker.ioc.xml.ref_di;

import com.checker.entity.User;
import com.checker.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RefDITest {
    @Test
    public void TestRef(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("com/checker/ioc/xml/ref_di/ref_bean.xml");

        UserService userService = context.getBean("userService", UserService.class);
        userService.add();

        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
}
