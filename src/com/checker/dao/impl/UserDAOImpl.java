package com.checker.dao.impl;

import com.checker.dao.UserDAO;
import com.checker.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
    @Override
    public void add() {
//        int i = 1 / 0;
        System.out.println("UserDAOImpl: add...");
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
