package com.checker.ioc.xml.autowire;

import com.checker.entity.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireTest {
    @Test
    public void autwireByTypeTest(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("com/checker/ioc/xml/autowire/aotuwire.xml");

        User userByType = context.getBean("userByType", User.class);
        System.out.println(userByType);
    }

    @Test
    public void autwireByNameTest(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("com/checker/ioc/xml/autowire/aotuwire.xml");

        User userByType = context.getBean("userByName", User.class);
        System.out.println(userByType);
    }
}
