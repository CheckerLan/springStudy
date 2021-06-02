package com.checker.dao.impl;

import com.checker.dao.UserDAO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("argUserDAO")
@Scope(value = "prototype")
public class AnnoWithArgUserDAOImpl implements UserDAO {
    @Override
    public void add() {
        System.out.println("AnnoWithArgUserDAO add...");
    }
}
