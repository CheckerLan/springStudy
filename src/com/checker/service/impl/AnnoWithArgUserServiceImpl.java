package com.checker.service.impl;

import com.checker.dao.UserDAO;
import com.checker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AnnoWithArgUserServiceImpl implements UserService {

    @Autowired
    @Qualifier("annoUserDAOImpl")
    private UserDAO userDAO;

    @Override
    public void add() {
        System.out.println("AnnoUserServiceImpl: add...");
        userDAO.add();
    }
}
