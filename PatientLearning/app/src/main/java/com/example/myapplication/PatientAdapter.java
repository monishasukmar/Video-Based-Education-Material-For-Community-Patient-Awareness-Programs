package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

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

public class PatientAdapter extends RecyclerView.Adapter< PatientAdapter.ViewHolder> {

    public String subname,subcode;
    public ArrayList<PatientHolder> patient;
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtsubcode,txtsubname,txtscore;
        public Button butStart;



        public CardView cardView;
        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
            txtsubcode= v.findViewById(R.id.txtsubcode);
            txtsubname= v.findViewById(R.id.txtsubname);
            txtscore=v.findViewById(R.id.txtscore);
            butStart=v.findViewById(R.id.butstart);
            butStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.e("received scode",subcode);
                    String pname,pph;
                    pname=patient.get(getAdapterPosition()).name;
                    pph=patient.get(getAdapterPosition()).phno;
                    StringRequest request1 = new StringRequest(Request.Method.POST, Const.ip+"/readPreQuestions.php", new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray a1 = new JSONArray(response);

                                ArrayList<Questions> questions=new ArrayList<>();

                    for (int i = 0; i < a1.length(); i++) {
                        Log.e("q","1 object");
                        JSONObject obj = a1.getJSONObject(i);
                        String q=obj.getString("Questions");
                        String op1=obj.getString("Op1");
                        String op2=obj.getString("Op2");
                        String op3=obj.getString("Op3");
                        String op4=obj.getString("Op4");
                        String ans=obj.getString("Ans");
                        questions.add(new Questions(q,op1,op2,op3,op4,ans));


                    }

                    Intent i=new Intent(v.getContext(),PreQuestionClass.class);

                                i.putExtra("scode",subcode);
                                i.putExtra("sname",subname);
                                i.putExtra("cur",getAdapterPosition());
                                Bundle bundle=new Bundle();
                                bundle.putSerializable("patient",patient);
                                bundle.putSerializable("questions",questions);
                                Log.e("q count inside",questions.size()+"");
                                i.putExtras(bundle);
                                v.getContext().startActivity(i);

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
                            params.put("v1", subcode);
                            return params;
                        }
                    };




                    RequestQueue queue = Volley.newRequestQueue(v.getContext());
                    queue.add(request1);




                }
            });


        }
    }

    public PatientAdapter(
                          ArrayList<PatientHolder> p,String code,String name) {

        subcode=code;
        subname=name;
        patient=p;
        Log.e("login scode",subcode);
    }

    @Override
    public PatientAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.patientview, parent, false);
        return new PatientAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PatientAdapter.ViewHolder holder, int position) {

        PatientHolder s= patient.get(position);


        holder.txtsubname.setText(s.name);
        holder.txtsubcode.setText(s.phno);
        holder.txtscore.setText("Score: "+s.pre);
    }

    @Override
    public int getItemCount() {
        return patient.size();
    }
}
