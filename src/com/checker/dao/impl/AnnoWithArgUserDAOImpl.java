package com.checker.dao.impl;

import com.checker.dao.UserDAO;
import com.checker.entity.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("argUserDAO")
@Scope(value = "prototype")
public class AnnoWithArgUserDAOImpl implements UserDAO {
    @Override
    public void add() {
        System.out.println("AnnoWithArgUserDAO add...");
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
