package com.checker.entity;

public class Employee {
    private Integer id;
    private String empname;
    private Integer gender;
    private String email;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee() {
    }

    public Employee(Integer id, String empname, Integer gender, String email) {
        this.id = id;
        this.empname = empname;
        this.gender = gender;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empname='" + empname + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                '}';
    }
}
