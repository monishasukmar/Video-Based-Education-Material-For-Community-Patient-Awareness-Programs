package com.example.myapplication;

import java.io.Serializable;

public class SubjectClass implements Serializable {
    public String subname;
    public String subcode;

    public SubjectClass(String subname, String subcode){
        this.subname = subname;
        this.subcode = subcode;
    }


}
