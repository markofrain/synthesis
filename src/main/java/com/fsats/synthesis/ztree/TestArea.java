package com.fsats.synthesis.ztree;

public class TestArea {
    private Integer id;
    private String name;
    private Integer pid;
    private String isp;
    private boolean isParent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        if(isp.equals("0")){
            this.isParent=false;
        }else{
            this.isParent=true;
        }
        this.isp=isp;
    }

    public boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(boolean isParent) {
        this.isParent = isParent;
    }
}
