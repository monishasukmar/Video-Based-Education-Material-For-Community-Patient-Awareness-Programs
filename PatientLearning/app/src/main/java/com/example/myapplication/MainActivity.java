package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

Button but;
EditText txtuser,txtpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent intent=new Intent(this, QuestionActivity.class);

        //startActivity(intent);

but=(Button)  findViewById(R.id.id_five);
txtuser=(EditText) findViewById(R.id.id_two);
txtpwd=(EditText) findViewById(R.id.id_four);

but.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {



        StringRequest request1 = new StringRequest(Request.Method.POST, Const.ip+"/a.php", new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONArray a1 = new JSONArray(response)
                            ;
                    Log.i("Count",a1.length()+"");
                    if(a1.length()==1)
                    {
                        Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(MainActivity.this, AddPatients.class);
                        startActivity(i);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Invalid login info", Toast.LENGTH_SHORT).show();
                    }
                    /*
                    for (int i = 0; i < a1.length(); i++) {
                        JSONObject obj = a1.getJSONObject(i);
                        String name = obj.getString("name");
                    }*/

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
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("v1", txtuser.getText().toString());
                params.put("v2", txtpwd.getText().toString());
                return params;
            }
        };


        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(request1);
    }
});

    }



}


