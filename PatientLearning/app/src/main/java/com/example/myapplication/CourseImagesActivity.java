package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CourseImagesActivity extends AppCompatActivity {

    ArrayList<String> url=new ArrayList<>();
    ArrayList<Bitmap> bitmaps=new ArrayList<>();
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_images);
        url= (ArrayList<String>) getIntent().getExtras().getSerializable("imgpath");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        bundle=getIntent().getExtras();
        Button but=(Button) findViewById(R.id.butpost);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CourseImagesActivity.this,PostTestHome.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {

                for(String url1: url)
                {

                    Log.i("urlread",url1);
                    Bitmap bitmap = null;
                    try {
                        InputStream in = new java.net.URL( Const.ip+"/"+ url1).openStream();
                        bitmap = BitmapFactory.decodeStream(in);
                    } catch (Exception e) {
                        Log.e("Error", e.getMessage());
                        e.printStackTrace();
                    }
                    bitmaps.add(bitmap);

                }




                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        RecyclerView rv = findViewById(R.id.recycler1);
                        CourseImageAdapter adapter=new CourseImageAdapter(bitmaps);
                        rv.setAdapter(adapter);
                        rv.setLayoutManager(new LinearLayoutManager(CourseImagesActivity.this, LinearLayoutManager.HORIZONTAL, false));


                    }
                });
            }
        });


    }
}