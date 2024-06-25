package com.example.myapplication;

import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class QuestionAnsAdapter extends RecyclerView.Adapter<QuestionAnsAdapter.ViewHolder> {
    private ArrayList<QuestionAnsAdapter> Crt_answers = new ArrayList<>();
    Context context;

    public QuestionAnsAdapter(Context context) {
        this.context = context;
    }

    public void setCrt_answers(ArrayList<QuestionAnsAdapter> crt_answers) {
        this.Crt_answers = crt_answers;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_form,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.answerTextView.getContext();
    }

    @Override
    public int getItemCount() {
        return Crt_answers.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView answerTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            answerTextView = itemView.findViewById(R.id.radio_answer);

        }
    }

}
