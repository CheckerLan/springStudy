package com.checker.ioc.anno.autowire;

import com.checker.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@ContextConfiguration(locations = "")
//@RunWith(SpringJUnit4ClassRunner.class)
public class AutowireTest {

    ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("com/checker/ioc/anno/autowire/autowire.xml");

    @Test
    public void mutiAutowiredTest(){
        UserService annoUserServiceImpl = context.getBean("annoUserServiceImpl", UserService.class);
        annoUserServiceImpl.add();
    }

    @Test
    public void qualifierTset(){
        UserService annoWithArgUserServiceImpl = context.getBean("annoWithArgUserServiceImpl", UserService.class);
        annoWithArgUserServiceImpl.add();
    }

}
