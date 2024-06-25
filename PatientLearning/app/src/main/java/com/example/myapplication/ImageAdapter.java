package com.example.myapplication;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private ArrayList<ImageClass> mData;
    Resources r;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleimage;
        public ImageView imageview;

        public CardView cardView;
        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
            titleimage= v.findViewById(R.id.txtimage);
            imageview= v.findViewById(R.id.imageview);
        }
    }

    public ImageAdapter(ArrayList< ImageClass > data, Resources r1) {
        mData = data;
        r=r1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_pic, parent, false);
        return new ViewHolder(v);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ImageClass s= mData.get(position);


     //  Bitmap b= BitmapFactory.decodeResource(r,s.imgid);
        //Bitmap b= BitmapFactory.decodeFile(s.imgid);
        holder.titleimage.setText(s.title);
        holder.imageview.setImageBitmap(s.bmp);

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }
} 
