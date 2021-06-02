package com.checker.ioc.anno.component;

import com.checker.dao.UserDAO;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnoComponentTest {
    ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("com/checker/ioc/anno/component/annoComponent.xml");
    
    @Test
    public void defaultAnnoTest(){
        UserDAO annoUserDAOImpl = context.getBean("annoUserDAOImpl", UserDAO.class);
        UserDAO annoUserDAOImpl1 = context.getBean("annoUserDAOImpl", UserDAO.class);

        annoUserDAOImpl.add();
        System.out.println(annoUserDAOImpl == annoUserDAOImpl1);
    }


    @Test
    public void argsAnnoTest(){
        UserDAO argUserDAO = context.getBean("argUserDAO", UserDAO.class);
        UserDAO argUserDAO1 = context.getBean("argUserDAO", UserDAO.class);

        argUserDAO.add();
        System.out.println(argUserDAO == argUserDAO1);
    }
}
