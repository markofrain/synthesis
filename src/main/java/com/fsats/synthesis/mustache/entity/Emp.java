package com.fsats.synthesis.mustache.entity;

import org.springframework.stereotype.Component;

/**
 * 员工类
 */
@Component("emp")
public class Emp {
    private String id;
    private String name;
    private String sex;
    private String address;
    private String salary;

    public Emp() {
    }

    public Emp(String id, String name, String sex, String address, String salary) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
