package com.checker.configEntity;

import com.checker.entity.User;

public class InstanceFactory {

    public User getUser(int id, String name) {
        System.out.println("instance factory");
        User user = new User();
        user.setUid(id);
        user.setUname(name);
        return user;
    }
}
