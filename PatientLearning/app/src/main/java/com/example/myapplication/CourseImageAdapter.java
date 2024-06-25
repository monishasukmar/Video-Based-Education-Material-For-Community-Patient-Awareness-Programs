package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseImageAdapter extends RecyclerView.Adapter< CourseImageAdapter.ViewHolder> {

    public ArrayList<Bitmap> mData;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;

        public CardView cardView;
        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
            img= v.findViewById(R.id.img1);
        }
    }

    public CourseImageAdapter(ArrayList<Bitmap> data) {
        mData = data;
    }

    @Override
    public CourseImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.imageholder, parent, false);
        return new CourseImageAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CourseImageAdapter.ViewHolder holder, int position) {

        Bitmap b=mData.get(position);

        holder.img.setImageBitmap(b);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
