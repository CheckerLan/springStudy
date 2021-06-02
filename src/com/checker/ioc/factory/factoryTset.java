package com.checker.ioc.factory;

import com.checker.entity.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class factoryTset {

    ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("com/checker/ioc/factory/factory.xml");

    @Test
    public void staticTest(){
        User staticUser = context.getBean("staticUser", User.class);
        System.out.println(staticUser);
    }

    @Test
    public void instanceTest(){
        User instanceUser = context.getBean("instanceUser", User.class);
        System.out.println(instanceUser);
    }


}
