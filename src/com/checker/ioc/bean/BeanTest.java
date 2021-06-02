package com.checker.ioc.bean;

import com.alibaba.druid.pool.DruidDataSource;
import com.checker.entity.Life;
import com.checker.entity.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
    ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("com/checker/ioc/bean/bean.xml");
    @Test
    public void factoryBeanTest() {
        User user = context.getBean("myFactoryBean", User.class);
        System.out.println(user);
    }

    @Test
    public void scopeTest() {

        User singletonUser1 = context.getBean("singletonUser", User.class);
        User singletonUser2 = context.getBean("singletonUser", User.class);
        System.out.println(singletonUser1.equals(singletonUser2));

        User prototypeUser1 = context.getBean("prototypeUser", User.class);
        User prototypeUser2 = context.getBean("prototypeUser", User.class);
        System.out.println(prototypeUser1.equals(prototypeUser2));
    }

    @Test
    public void lifeTest() {

        Life life = context.getBean("life", Life.class);

        System.out.println("（获取到了bean并使用：" + life + "）");

        // 关闭context并销毁bean
        context.close();
    }

    @Test
    public void orderTest(){
        // context在new的时候，bean就已被创建
    }

    @Test
    public void outputTest() {

        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        dataSource.close();

        DruidDataSource dataSource1 = context.getBean("dataSource1", DruidDataSource.class);
        dataSource1.close();
    }
}
