package com.example.myapplication;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class ImageClass {
    public String title;

    public Bitmap bmp;
    public int imgid;

    public ImageView imgview;

    public ImageClass(String image1, int medimage2) {

    }

    public ImageClass(String image1, String medimage2) {

    }

    public void SubjectClass(String title, ImageView imgview){
        this.title = title;
        this.imgview = imgview;
    }

    public void SubjectClass(String title, int imgview){
        this.title = title;
        this.imgid = imgview;
    }

    public ImageClass(String title, Bitmap imgview){
        this.title = title;
        this.bmp = imgview;
    }

}
