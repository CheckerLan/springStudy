package com.checker.dao.impl;

import com.checker.dao.UserDAO;
import org.springframework.stereotype.Repository;

@Repository
public class AnnoUserDAOImpl implements UserDAO {
    @Override
    public void add() {
        System.out.println("AnnoUserDAO add...");
    }
}
