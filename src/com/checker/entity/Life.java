package com.checker.entity;

public class Life {
    private String attr;

    public Life() {
        System.out.println("- 实例化...");
    }

    public void setAttr(String attr) {
        System.out.println("- 依赖注入...");
        this.attr = attr;
    }

    public void initMethod(){
        System.out.println("- 初始化...");
    }

    public void destoryMethod(){
        System.out.println("- 销毁...");
    }

}
