package com.checker.entity;

public class User {
    int uid;
    String uname;
    Dept udept;

    // 设置setter方法后才可以进行属性注入
    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setUdept(Dept udept) {
        this.udept = udept;
    }

    // 设置getter后可以直接通过udept.xxx赋值
    public Dept getUdept() {
        return udept;
    }

    // 默认使用无参构造，如果指定了有参构造方法，则默认的无参会失效
    public User() {
        System.out.println("user被创建");
    }

    public User(int uid, String uname) {
        this.uid = uid;
        this.uname = uname;
    }

    public User(int uid, String uname, Dept udept) {
        this.uid = uid;
        this.uname = uname;
        this.udept = udept;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", udept=" + udept +
                '}';
    }


}
