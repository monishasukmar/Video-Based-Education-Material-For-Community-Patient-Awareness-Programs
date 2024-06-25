package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class PickCourse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_subject);

        RecyclerView rv=(RecyclerView) findViewById(R.id.r1);


        Bundle bndArray = this.getIntent().getExtras();

        ArrayList<PatientHolder> patient = (ArrayList<PatientHolder>) bndArray.getSerializable("patient");
        ArrayList<SubjectClass> sc=(ArrayList<SubjectClass>) bndArray.getSerializable("a");


        SubjectAdapter sa=new SubjectAdapter(sc,patient);

        rv.setAdapter(sa);

        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}