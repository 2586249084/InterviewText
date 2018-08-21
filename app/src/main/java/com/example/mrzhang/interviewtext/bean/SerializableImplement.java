package com.example.mrzhang.interviewtext.bean;

import java.io.Serializable;

public class SerializableImplement implements Serializable{

    /**
     * 生成序列号标识
     */
    private static final long serialVersionUID = -208323604564L;

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
