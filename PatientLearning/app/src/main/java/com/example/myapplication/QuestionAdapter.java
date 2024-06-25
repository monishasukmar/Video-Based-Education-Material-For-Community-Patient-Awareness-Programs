package com.example.myapplication;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    public void setQuestions(ArrayList<QuestionHolder> questions) {
        this.questions = questions;
        notifyDataSetChanged();

    }

    private ArrayList<QuestionHolder> questions = new ArrayList<>();
    private Context context;




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_form, parent, false);
        ViewHolder holder  = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        QuestionHolder question = questions.get(position);
        holder.questionTextView.setText(question.getQuestion());
        Log.e("vals",question.ans1+","+question.ans2+question.ans3+ question.ans4);
        holder.r1.setText(question.ans1);
        holder.r2.setText(question.ans2);
        holder.r3.setText(question.ans3);
        holder.r4.setText(question.ans4);
    }


    @Override
    public int getItemCount() {
        return questions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView questionTextView;

        public RadioButton r1,r2,r3,r4;

        public RadioGroup answersRecyclerView;

        public ViewHolder(View itemView) {
            super(itemView);
            questionTextView = itemView.findViewById(R.id.text_view_question);
            answersRecyclerView = (RadioGroup) itemView.findViewById(R.id.recycler_view_answers);
            r1 =(RadioButton)itemView.findViewById(R.id.radio_answer);
            r2=(RadioButton)itemView.findViewById(R.id.radio_button2);
            r3=(RadioButton)itemView.findViewById(R.id.radio_button3);
            r4=(RadioButton)itemView.findViewById(R.id.radio_button4);

        }
    }
}

