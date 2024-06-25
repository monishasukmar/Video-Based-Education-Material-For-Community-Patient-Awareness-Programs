package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ImageActivity extends AppCompatActivity {


    class DownloadsImage extends AsyncTask<String, Void,Void> {



        ArrayList<Bitmap> ll=new ArrayList<>();
        @Override
        protected Void doInBackground(String... arrayLists) {

            for(String s: arrayLists)
            {
                Log.e("strinput",s);
                URL url = null;
                try {
                    url = new URL(s);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                Bitmap bm = null;
                try {
                    bm =    BitmapFactory.decodeStream(url.openConnection().getInputStream());
                ll.add(bm);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);


            RecyclerView rv=(RecyclerView) findViewById(R.id.re1);
            ArrayList<ImageClass> sc= new ArrayList<ImageClass>();

            for(Bitmap b:ll)
            {
                sc.add(new ImageClass("",b));
            }
            Resources r=getResources();
            ImageAdapter adapter = new ImageAdapter(sc,r);
            rv.setAdapter(adapter);
            rv.setLayoutManager(new LinearLayoutManager(ImageActivity.this));

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

/*        RecyclerView rv=(RecyclerView) findViewById(R.id.re1);
        ArrayList<ImageClass> sc= new ArrayList<ImageClass>();
        Log.i("img",R.drawable.medimage2+"");
*/
//        new DownloadsImage().execute(Const.ip+"/medimage1.jpg",Const.ip+"/medimage1.jpg");

       // sc.add(new ImageClass("image1", getResources().getResourceEntryName( R.drawable.medimage2)));
  /*      sc.add(new ImageClass("image2", R.drawable.medimage4));
        sc.add(new ImageClass("image2", R.drawable.medimage4));
        sc.add(new ImageClass("image2", R.drawable.medimage4));

*/


        RecyclerView rv=(RecyclerView) findViewById(R.id.re1);
        ArrayList<ImageClass> sc= new ArrayList<ImageClass>();

        sc.add(new ImageClass("",""));
        sc.add(new ImageClass("",""));
        sc.add(new ImageClass("",""));
        Resources r=getResources();
        ImageAdapter adapter = new ImageAdapter(sc,r);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(ImageActivity.this));


    }
}