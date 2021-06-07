package com.checker.entity;

import java.io.Serializable;
import java.util.Date;

public class Teacher implements Serializable {
    private Integer tid;
    private String tname;
    private String className;
    private String address;
    private Date birthDay;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", className='" + className + '\'' +
                ", address='" + address + '\'' +
                ", brithDay=" + birthDay +
                '}';
    }
}
