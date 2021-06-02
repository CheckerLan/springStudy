package com.checker.service.impl;

import com.checker.dao.UserDAO;
import com.checker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AnnoUserServiceImpl implements UserService {

    @Autowired
    private UserDAO annoUserDAOImpl;

    @Override
    public void add() {
        System.out.println("AnnoUserServiceImpl: add...");
        annoUserDAOImpl.add();
    }
}
