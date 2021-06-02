package com.checker.ioc.xml.getbean;

import com.checker.entity.Dept;
import com.checker.entity.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetbeanTest {
    ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("com/checker/ioc/xml/getbean/getBean.xml");

    @Test
    public void getBeanByName(){
        User user = (User) context.getBean("user");
        System.out.println(user);
    }

    @Test
    public void getSingleBeanByType(){
        User user = context.getBean(User.class);
        System.out.println(user);
    }

    @Test
    public void getMutiBeanByBoth(){
        Dept dept = context.getBean("udept", Dept.class);
        Dept dept2 = context.getBean("udept2", Dept.class);
        System.out.println(dept);
        System.out.println(dept2);
    }

    @Test
    public void parentTest(){
        Dept udept3 = context.getBean("udept3", Dept.class);
        System.out.println(udept3);
    }

    @Test
    public void abstractTest(){
        Dept udeptParent = context.getBean("udeptParent", Dept.class);
        System.out.println(udeptParent);
    }

}
