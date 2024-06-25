package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class oneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        RecyclerView rv= (RecyclerView) findViewById(R.id.a1);
        ArrayList<oneHolder> sc = new ArrayList<oneHolder>();
        sc.add(new oneHolder("1","abc"));
        sc.add(new oneHolder("2","def"));
        sc.add(new oneHolder("3","gh"));

        OneAdapter oa= new OneAdapter();
        oa.setmData(sc);
        rv.setAdapter(oa);

        rv.setLayoutManager(new LinearLayoutManager(this));

    }
}