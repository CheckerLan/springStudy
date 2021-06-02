package com.checker.ioc.iocexample;

import com.checker.dao.UserDAO;
import com.checker.dao.impl.UserDAOImpl;

public class UserFactory {
    public static UserDAO getUserDAO() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        // <bean id="dao" class="com.checker.dao.impl.UserDAOImpl"></bean>

        // 模拟从xml中读取bean信息
        String classname = UserDAOImpl.class.getName();

        // 反射创建对应的对象
        Class clazz = Class.forName(classname);
        UserDAO userDAOImpl = (UserDAO)clazz.newInstance();

        return userDAOImpl;
    }
}
