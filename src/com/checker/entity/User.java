package com.checker.entity;

public class User {
    int uid;
    String uname;
    Dept dept;

    // 设置setter方法后才可以进行属性注入

    public int getUid() {
        return uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    // 设置getter后可以直接通过udept.xxx赋值
    public Dept getDept() {
        return dept;
    }

    // 默认使用无参构造，如果指定了有参构造方法，则默认的无参会失效
    public User() {
        System.out.println("user被创建");
    }

    public User(int uid, String uname) {
        this.uid = uid;
        this.uname = uname;
    }

    public User(int uid, String uname, Dept dept) {
        this.uid = uid;
        this.uname = uname;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", udept=" + dept +
                '}';
    }


}
