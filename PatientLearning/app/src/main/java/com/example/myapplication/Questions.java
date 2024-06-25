package com.example.myapplication;

import java.io.Serializable;

public class Questions implements Serializable {
    public String title,op1,op2,op3,op4,correct;

    public Questions(String title, String op1, String op2, String op3, String op4, String correct) {
        this.title = title;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
        this.correct = correct;
    }
}
