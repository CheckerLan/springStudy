package com.checker.aop.exam;

import com.checker.dao.UserDAO;
import com.checker.dao.impl.UserDAOImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath*:com/checker/aop/exam/aopTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AopTest {

    @Autowired
    UserDAO userDAOImpl;

    @Test
    public void testAop(){
        userDAOImpl.add();
    }
    @Test
    public void testClass(){
        System.out.println(userDAOImpl);
        System.out.println(userDAOImpl.getClass());
    }


}
