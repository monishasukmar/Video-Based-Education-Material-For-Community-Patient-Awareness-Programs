package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class PreQuestionClass extends AppCompatActivity implements OnRadioButtonSelectedListener {

    ArrayList<String> options=new ArrayList<>();
    int cur;
    String subcode;
    String subname;

    ArrayList<PatientHolder> patients;
    ArrayList<Questions> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_question_class);





        subcode=getIntent().getExtras().getString("scode");
        subname=getIntent().getExtras().getString("sname");
        cur=getIntent().getExtras().getInt("cur");
        TextView txt=(TextView) findViewById(R.id.txtpatient);

        patients=(ArrayList<PatientHolder>) getIntent().getExtras().getSerializable("patient");
        questions=(ArrayList<Questions>) getIntent().getExtras().getSerializable("questions");

        txt.setText(patients.get(cur).name);

        for (Questions q:questions)
        {
            options.add("");
        }




        RecyclerView rv=(RecyclerView) findViewById(R.id.recycler1);
        PreClassQuestionAdapter a=new PreClassQuestionAdapter(questions,this);
        rv.setAdapter(a);
        rv.setLayoutManager(new LinearLayoutManager(this));


        Button b=(Button) findViewById(R.id.butsave);

        Button b1=(Button) findViewById(R.id.butsaveall);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score=0;
                for(int i=0;i<questions.size();i++)
                {
                    if (options.get(i).equals(questions.get(i).correct))
                        score++;

                }
                Log.e("score","Score = "+score);
                patients.get(cur).pre=score;


                Intent i=new Intent(PreQuestionClass.this, PreTestHome.class);

                i.putExtra("scode",subcode);
                i.putExtra("sname",subname);
                Log.e("Passing scode",subcode);
                Log.e("Passing sname",subname);
                Bundle bundle=new Bundle();
                bundle.putSerializable("patient",patients);
                i.putExtras(bundle);
                v.getContext().startActivity(i);


            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score=0;
                for(int i=0;i<questions.size();i++)
                {
                    if (options.get(i).equals(questions.get(i).correct))
                        score++;

                }
                for(int i=0;i<patients.size();i++)
                {
                    patients.get(i).pre=score;
                }
                Intent i=new Intent(PreQuestionClass.this, PreTestHome.class);

                i.putExtra("scode",subcode);
                i.putExtra("sname",subname);
                Bundle bundle=new Bundle();
                bundle.putSerializable("patient",patients);
                i.putExtras(bundle);
                v.getContext().startActivity(i);

            }
        });


    }

    @Override
    public void onRadioButtonSelected(int position, String text) {
        options.set(position,text);
    }
}