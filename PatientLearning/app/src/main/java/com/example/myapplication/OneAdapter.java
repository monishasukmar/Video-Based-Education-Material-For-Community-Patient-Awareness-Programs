package com.example.myapplication;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class OneAdapter extends RecyclerView.Adapter<OneAdapter.ViewHolder> {



    private ArrayList<oneHolder> mData = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_one,parent,false);
        ViewHolder holder = new ViewHolder((CardView) view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.txttreatcode.setText(mData.get(position).treatcode);
    holder.txttreatname.setText(mData.get(position).treatname);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setmData(ArrayList<oneHolder> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView txttreatcode,txttreatname;

            public CardView cardView;
            public ViewHolder(CardView v) {
                super(v);
                cardView = v;
                txttreatcode= v.findViewById(R.id.txttreatcode);
                txttreatname= v.findViewById(R.id.txttreatname);
            }
        }


}




