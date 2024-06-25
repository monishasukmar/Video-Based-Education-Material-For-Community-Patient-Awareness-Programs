package com.example.myapplication;

public class oneHolder {

    String treatcode;
    String treatname;

    public String getTreatcode() {
        return treatcode;
    }

    public void setTreatcode(String treatcode) {
        this.treatcode = treatcode;
    }

    public String getTreatname() {
        return treatname;
    }

    public void setTreatname(String treatname) {
        this.treatname = treatname;
    }

    public oneHolder(String treatcode, String treatname) {
        this.treatcode = treatcode;
        this.treatname = treatname;
    }


}
