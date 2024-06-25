package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;


public class QuestionActivity extends AppCompatActivity {
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        rv = findViewById(R.id.re2);

        ArrayList<QuestionHolder> sc= new ArrayList<QuestionHolder>();
        sc.add(new QuestionHolder("One","a","b","c","d"));


        QuestionAdapter sa=new QuestionAdapter();
        QuestionAnsAdapter ans = new QuestionAnsAdapter(this);

        sa.setQuestions(sc);

        rv.setAdapter(sa);

        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}

