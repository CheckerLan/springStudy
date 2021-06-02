package com.checker.entity;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean {
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getObject() throws Exception {
        // 模拟创建单例并返回
        User user = new User();
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
