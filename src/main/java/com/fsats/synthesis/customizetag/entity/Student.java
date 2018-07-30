package com.fsats.synthesis.customizetag.entity;

import org.springframework.stereotype.Component;

/**
 * 学生表
 */
@Component("student")
public class Student {

    private String id;      //学生编号
    private String name;    //姓名
    private String sex;     //性别
    private String age;     //年龄
    private String address; //地址
    private String high;    //身高
    private Grade grade;    //年级

    public static final String SEX_MALE = "男";
    public static final String SEX_FEMALE = "女";

    public Student() {
    }

    public Student(String id, String name, String sex, String age, String address, String high) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.high = high;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", high='" + high + '\'' +
                ", grade=" + grade +
                '}';
    }
}
