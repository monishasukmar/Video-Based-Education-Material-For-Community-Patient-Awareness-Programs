package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

public class PostTestHome extends AppCompatActivity {

    ArrayList<PatientHolder> patientHolders;
    String scode,sname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_test_home);


        scode=getIntent().getExtras().getString("scode");
        sname=getIntent().getExtras().getString("sname");
        patientHolders= (ArrayList<PatientHolder>) getIntent().getExtras().getSerializable("patient");


        RecyclerView rv=(RecyclerView) findViewById(R.id.rec1);
        Log.e("scode rr",scode);
        Log.e("same ee",sname);
        PatientAdapterPost adapter = new PatientAdapterPost(patientHolders,scode,sname);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        Button but=(Button) findViewById(R.id.butstart);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringRequest request1 = new StringRequest(Request.Method.POST, Const.ip+"/insertData.php", new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        Intent i=new Intent(PostTestHome.this,ThankYou.class);
                        startActivity(i);

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
                        try {
                            JSONArray array=new JSONArray();
                            for(PatientHolder p: patientHolders)
                            {
                                JSONObject object=new JSONObject();
                                object.put("pname",p.name);
                                object.put("pphno",p.phno);
                                object.put("ccode",scode);
                                object.put("spre",p.pre);
                                object.put("spost",p.post);
                                array.put(object);
                            }
                            params.put("v1", array.toString());
                            Log.e("vals",array.toString());
                        }
                        catch (JSONException e)
                        {

                        }

                        return params;
                    }
                };
                RequestQueue queue = Volley.newRequestQueue(PostTestHome.this);
                queue.add(request1);
            }
        });
    }
}