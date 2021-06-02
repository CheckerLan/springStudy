package com.checker.ioc.iocexample;

import com.checker.dao.UserDAO;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIOCTest {
    @Test
    public void test(){

        // 加载xml配置
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("com/checker/ioc/iocexample/bean.xml");
        // 获取bean
        UserDAO userDAOImpl = context.getBean("userDAOImpl", UserDAO.class);
        userDAOImpl.add();
    }
}

