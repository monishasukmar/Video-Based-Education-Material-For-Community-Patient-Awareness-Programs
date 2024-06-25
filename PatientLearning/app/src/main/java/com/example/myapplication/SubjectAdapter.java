package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class SubjectAdapter extends RecyclerView.Adapter< SubjectAdapter.ViewHolder> {

    public ArrayList<SubjectClass> mData;

    public ArrayList<PatientHolder> patient;
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtsubcode,txtsubname;

        public CardView cardView;
        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
            txtsubcode= v.findViewById(R.id.txtsubcode);
            txtsubname= v.findViewById(R.id.txtsubname);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(v.getContext(), PreTestHome.class);
                    String code=mData.get(getAdapterPosition()).subcode;
                    String name=mData.get(getAdapterPosition()).subname;
                    i.putExtra("scode",code);
                    i.putExtra("sname",name);
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("patient",patient);
                    i.putExtras(bundle);
                    v.getContext().startActivity(i);
                }
            });
        }
    }

    public SubjectAdapter(ArrayList< SubjectClass > data,
                          ArrayList<PatientHolder> p) {
        mData = data;
        patient=p;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.subjectview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        SubjectClass s= mData.get(position);


        holder.txtsubname.setText(s.subname);
        holder.txtsubcode.setText(s.subcode);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
