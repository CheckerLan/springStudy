package com.checker.dao;

import com.checker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericBaseDAO<T> {

    public void add(){
        System.out.println("add方法");
    };
}
