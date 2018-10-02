package com.fang.model;

import java.util.Date;

public class Good {
    private Integer id;

    private String chicontent;

    private String engcontent;

    private Date date;

    private String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChicontent() {
        return chicontent;
    }

    public void setChicontent(String chicontent) {
        this.chicontent = chicontent == null ? null : chicontent.trim();
    }

    public String getEngcontent() {
        return engcontent;
    }

    public void setEngcontent(String engcontent) {
        this.engcontent = engcontent == null ? null : engcontent.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }
}