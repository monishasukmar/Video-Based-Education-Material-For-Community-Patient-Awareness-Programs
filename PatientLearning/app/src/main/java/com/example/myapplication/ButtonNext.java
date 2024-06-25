package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ButtonNext extends AppCompatActivity {
    TextView txt1,txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_next);

      /*  txt1= findViewById(R.id.txt1);
        Bundle bndText= this.getIntent().getExtras();
        txt1.setText(bndText.getString("Text"));


        txt2 = findViewById(R.id.txt2);
        Bundle bndText2= this.getIntent().getExtras();
        txt2.setText(bndText2.getString("Text2"));  */

        Bundle bndArray = this.getIntent().getExtras();

        ArrayList<CourseHolder> ll=(ArrayList<CourseHolder>) bndArray.getSerializable("a");
        Log.e("Target Count",ll.size()+"");

        for(CourseHolder h: ll)
        {

        }
    }
}