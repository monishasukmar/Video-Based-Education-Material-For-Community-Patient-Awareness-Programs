package com.example.myapplication;

public class Answers {
    String correctans;

    public Answers(String correctans) {
        this.correctans = correctans;
    }
    public String getCorrectans() {
        return correctans;
    }

    public void setCorrectans(String correctans) {
        this.correctans = correctans;
    }

    @Override
    public String toString() {
        return "Answers{" +
                "correctans='" + correctans + '\'' +
                '}';
    }
}
