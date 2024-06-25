package com.example.myapplication;

import java.io.Serializable;

public class CourseHolder implements Serializable {
    public String name, code;

    public CourseHolder(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
