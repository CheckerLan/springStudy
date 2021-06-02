package com.checker.ioc.xml.di_xml;

import com.checker.entity.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {

    @Test
    public void testXmlDI() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("com/checker/ioc/xml/di_xml/bean_xml.xml");

        User user1 = context.getBean("user1", User.class);
        System.out.println(user1);

        User user2 = context.getBean("user2", User.class);
        System.out.println(user2);

        User user3 = context.getBean("user3", User.class);
        System.out.println(user3);

        User user_sp = context.getBean("user_sp", User.class);
        System.out.println(user_sp);

        User user_p = context.getBean("user_p", User.class);
        System.out.println(user_p);

    }

}
