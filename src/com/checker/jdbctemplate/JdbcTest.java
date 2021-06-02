package com.checker.jdbctemplate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("com/checker/jdbctemplate/jdbc.xml");
    JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

    @Test
    public void testJdbc(){
        System.out.println(jdbcTemplate);
    }


}
