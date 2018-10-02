package com.fang.model;

public class Category {
    private Integer id;

    private String chiname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChiname() {
        return chiname;
    }

    public void setChiname(String chiname) {
        this.chiname = chiname == null ? null : chiname.trim();
    }
}