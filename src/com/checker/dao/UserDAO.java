package com.checker.dao;

import com.checker.entity.User;

public interface UserDAO {
    public void add();

    public User getUser(Integer id);

    public Integer insertUser(User user);

}
