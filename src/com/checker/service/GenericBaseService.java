package com.checker.service;

import com.checker.dao.GenericBaseDAO;
import com.checker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericBaseService<T> {

    @Autowired
    GenericBaseDAO<T> baseDAO;

    public void add() {
        System.out.println("注入的dao" + baseDAO);
        baseDAO.add();
    }

}
