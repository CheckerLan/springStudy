package com.checker.dao.impl;

import com.checker.dao.UserDAO;
import com.checker.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class AnnoUserDAOImpl implements UserDAO {
    @Override
    public void add() {
        System.out.println("AnnoUserDAO add...");
    }

    @Override
    public User getUser(Integer id) {
        return null;
    }

    @Override
    public Integer insertUser(User user) {
        return null;
    }
}
