package com.fsats.synthesis.jquerytreetable.entity;

/**
 * 区域表
 */
public class Area {
    private String id;          //编号
    private String name;        //名称
    private String parentId;//父级id
    private String type;    //区域类型（1：国家；2：省份、直辖市；3：地市；4：区县）
    private String description;

    public Area() {
    }

    public Area(String id, String name, String parentId, String type) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.type = type;
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
