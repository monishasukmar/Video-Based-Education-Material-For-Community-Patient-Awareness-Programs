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
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddPatients extends AppCompatActivity {
    Button buttonnext;
    Button add;
    ArrayList<PatientHolder> ll=new ArrayList<>();
    EditText edtText1,edtText2;
    ArrayList<String> arlText = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        add=(Button) findViewById(R.id.button_add);
        arlText = new ArrayList();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll.add(new PatientHolder(edtText1.getText().toString(),edtText2.getText().toString()));
                edtText1.setText("");
                edtText2.setText("");
                Toast.makeText(AddPatients.this, "Patient added", Toast.LENGTH_SHORT).show();
            }
        });


        edtText1 = findViewById(R.id.edtText1);
        edtText2 = findViewById(R.id.edtText2);

        buttonnext= findViewById(R.id.button_next);
        buttonnext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                StringRequest request1 = new StringRequest(Request.Method.POST, Const.ip+"/c.php", new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            ArrayList<SubjectClass> ll=new ArrayList<>();

                            JSONArray a1 = new JSONArray(response);

                            for (int i = 0; i < a1.length(); i++) {
                                JSONObject obj = a1.getJSONObject(i);
                                String code = obj.getString("ccode");
                                String name = obj.getString("cname");
                                Log.e("name",name);
                                ll.add(new SubjectClass(name,code));
                            }

                            Log.e("Count",ll.size()+"");
                            Intent i=new Intent(AddPatients.this, PickCourse.class);
                            Bundle bndSend = new Bundle();

                            bndSend.putSerializable("a",ll);

                            bndSend.putSerializable("patient", AddPatients.this.ll);
                            i.putExtras(bndSend);
                            startActivity(i);



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("error", error.toString());
                        Toast.makeText(AddPatients.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        return params;
                    }
                };


                RequestQueue queue = Volley.newRequestQueue(AddPatients.this);
                queue.add(request1);












            }
        });
    }
}