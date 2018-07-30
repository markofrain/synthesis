package com.fsats.synthesis.customizetag.entity;

/**
 * 字典表
 */
public class Dict {

    private String id;      //字典某值编号
    private String type;    //字典类型
    private String sort;     //键
    private String value;   //值

    public Dict() {
    }

    public Dict(String id, String type, String sort, String value) {
        this.id = id;
        this.type = type;
        this.sort = sort;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
