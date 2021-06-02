package com.checker.ioc.xml.container_di;

import com.checker.entity.ContEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

public class ContainerDITest {

    @Test
    public void containerTest() {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("com/checker/ioc/xml/container_di/container_bean.xml");

        ContEntity contEntity = context.getBean("contEntity", ContEntity.class);
        System.out.println(contEntity);

        ContEntity contEntity2 = context.getBean("contEntity2", contEntity.getClass());
        System.out.println(contEntity2);

    }
}
