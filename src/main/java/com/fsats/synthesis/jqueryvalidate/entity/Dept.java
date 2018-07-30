package com.fsats.synthesis.jqueryvalidate.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 部门类
 */
@Component
public class Dept {

    private String id;              //编号
    private String name;            //部门名称
    private String address;         //部门地址
    private String area;            //部门面积
    private Date establishDate;     //成立时间
    private String phone;           //部门电话

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Date getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(Date establishDate) {
        this.establishDate = establishDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", area='" + area + '\'' +
                ", establishDate=" + establishDate +
                ", phone='" + phone + '\'' +
                '}';
    }
}
