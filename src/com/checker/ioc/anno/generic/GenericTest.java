package com.checker.ioc.anno.generic;

import com.checker.dao.impl.GenericUserDAOExt;
import com.checker.service.GenericBaseService;
import com.checker.service.impl.GenericDeptServiceExt;
import com.checker.service.impl.GenericUserServiceExt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath*:/com/checker/ioc/anno/generic/generic.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class GenericTest {

    @Autowired
    GenericUserServiceExt genericUserServiceExt;

    @Autowired
    GenericDeptServiceExt genericDeptServiceExt;

    @Test
    public void genericTest(){
        genericDeptServiceExt.add();
        genericUserServiceExt.add();

        // 实际是根据带泛型的父类进行注入
        System.out.println(genericDeptServiceExt.getClass().getGenericSuperclass());
        System.out.println(genericUserServiceExt.getClass().getGenericSuperclass());
    }

}
