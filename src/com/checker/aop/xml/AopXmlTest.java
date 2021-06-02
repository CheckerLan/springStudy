package com.checker.aop.xml;


import com.checker.dao.UserDAO;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopXmlTest {

    ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("com/checker/aop/xml/aopXml.xml");

    @Test
    public void TestXmlAop(){
        UserDAO userDAO = (UserDAO) context.getBean("userDAO");
        userDAO.add();
    }

}
