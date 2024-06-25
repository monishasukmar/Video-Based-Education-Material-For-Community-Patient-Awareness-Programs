package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class MainActivity2 extends AppCompatActivity {

    ArrayList<UserHolder> al=new ArrayList<UserHolder>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        StringRequest request1 = new StringRequest(Request.Method.POST, "http:// 192.168.0.103/app proj/b.php", new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONArray a1 = new JSONArray(response);

                    for (int i = 0; i < a1.length(); i++) {
                        JSONObject obj = a1.getJSONObject(i);
                        String name = obj.getString("name");
                        UserHolder u=new UserHolder();
                        u.name=obj.getString("Uname");
                        u.pwd=obj.getString("Pwd");
                        al.add(u);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error", error.toString());
                Toast.makeText(MainActivity2.this, "Error", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };


        RequestQueue queue = Volley.newRequestQueue(MainActivity2.this);
        queue.add(request1);




}
}