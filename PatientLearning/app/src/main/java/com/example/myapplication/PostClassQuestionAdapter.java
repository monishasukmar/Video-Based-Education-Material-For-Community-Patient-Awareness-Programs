package com.example.myapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostClassQuestionAdapter extends RecyclerView.Adapter< PostClassQuestionAdapter.ViewHolder> {

    public ArrayList<Questions> mData;
    public OnRadioButtonSelectedListener listener;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtquestion;


        public RadioButton r1,r2,r3,r4;
        public CardView cardView;
        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
            txtquestion= v.findViewById(R.id.txtquestion);
            r1=v.findViewById(R.id.radio1);
            r2=v.findViewById(R.id.radio2);
            r3=v.findViewById(R.id.radio3);
            r4=v.findViewById(R.id.radio4);



        }
    }

    public PostClassQuestionAdapter(ArrayList< Questions > data, OnRadioButtonSelectedListener r
    ) {
        mData = data;
        Log.e("pcqa count",mData.size()+"");
        listener=r;

    }

    @Override
    public PostClassQuestionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.questionview, parent, false);
        return new PostClassQuestionAdapter.ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(PostClassQuestionAdapter.ViewHolder holder, int position) {

        Log.e("Creating1","Creating1");
        Questions s= mData.get(position);
        holder.txtquestion.setText(s.title);
        holder.r1.setText(s.op1);
        holder.r2.setText(s.op2);
        holder.r3.setText(s.op3);
        holder.r4.setText(s.op4);


        holder.r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRadioButtonSelected(holder.getAdapterPosition(),holder.r1.getText().toString());
            }
        });
        holder.r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRadioButtonSelected(holder.getAdapterPosition(),holder.r2.getText().toString());
            }
        });
        holder.r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRadioButtonSelected(holder.getAdapterPosition(),holder.r3.getText().toString());
            }
        });
        holder.r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRadioButtonSelected(holder.getAdapterPosition(),holder.r4.getText().toString());
            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}

