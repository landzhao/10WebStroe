package com.cskaoyan.bean;

public class Category {

    String id;
    String cname ;

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
