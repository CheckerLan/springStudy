package com.checker.service.impl;

import com.checker.dao.UserDAO;
import com.checker.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    // xml注入需要setter方法
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void add() {
        System.out.println("UserServiceImpl: add...");
        userDAO.add();
    }
}
