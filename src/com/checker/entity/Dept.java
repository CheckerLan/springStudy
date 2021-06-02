package com.checker.entity;

public class Dept {
    private int did;
    private String dname;

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public Dept() {
        System.out.println("dept被创建");
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                '}';
    }

}
