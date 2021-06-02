package com.checker.configEntity;

import com.checker.entity.User;

public class StaticFactory {

    public static User getUser(int id, String name) {
        System.out.println("static factory");
        User user = new User();
        user.setUid(id);
        user.setUname(name);
        return user;
    }
}
