package com.example.myapplication;

import java.io.Serializable;

public class PatientHolder implements Serializable {

    public String name,phno;

    public PatientHolder(String name, String phno) {
        this.name = name;
        this.phno = phno;
        pre=0;
        post=0;
    }

    public int pre,post;

}
