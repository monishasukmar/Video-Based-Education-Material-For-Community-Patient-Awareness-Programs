package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PreTestHome extends AppCompatActivity {

    TextView txt;
    Bundle bundle;
    String name,code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        TextView t1=(TextView) findViewById(R.id.txtsubname);

        //patient
        ArrayList <PatientHolder> ll= (ArrayList<PatientHolder>) getIntent().getExtras().getSerializable("patient");

        bundle=getIntent().getExtras();

        Log.e("size of the list",ll.size()+"");
        name=getIntent().getExtras().getString("sname");
        code=(String) getIntent().getExtras().getString("scode");
        t1.setText(name+"-"+code);


        RecyclerView rv=(RecyclerView) findViewById(R.id.rec1);
        PatientAdapter adapter = new PatientAdapter(ll,code,name);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));


        Button but=(Button) findViewById(R.id.butstart);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                StringRequest request1 = new StringRequest(Request.Method.POST, Const.ip+"/viewImgs.php", new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        ArrayList<String> url=new ArrayList<>();
                        try {
                            JSONArray a1 = new JSONArray(response);
                            for(int i=0;i<a1.length();i++){
                                JSONObject obj = a1.getJSONObject(i);
                                String name = obj.getString("paths");
                                url.add(name);
                            }
                            Intent i=new Intent(PreTestHome.this, CourseImagesActivity.class);
                            bundle.putSerializable("imgpath",url);
                            i.putExtras(bundle);
                            startActivity(i);

                        } catch (JSONException e) {
                            Log.e("json",response);
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("error", error.toString());
                        error.printStackTrace();

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("v1", code);
                        return params;
                    }
                };


                RequestQueue queue = Volley.newRequestQueue(PreTestHome.this);
                queue.add(request1);

            }
        });


    }
}