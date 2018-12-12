package com.example.immadisairaj.quiz.solution;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.immadisairaj.quiz.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder> {
    private ArrayList<Integer> Answers;
    private List<Integer> Answer;
    private List<String> optA;
    private List<String> optB;
    private List<String> optC;
    private List<String> optD;

    AnswerAdapter(ArrayList<Integer> answers, List<Integer> answer, List<String> optionsA, List<String> optionsB, List<String> optionsC, List<String> optionsD) {
        Answers = answers;
        Answer = answer;
        optA = optionsA;
        optB = optionsB;
        optC = optionsC;
        optD = optionsD;
    }

    @Override
    public int getItemCount() {
        return Answer.size();
    }

    @Override
    public void onBindViewHolder(@NonNull AnswerViewHolder answerViewHolder, int i) {
        String qus = "Q."+(i + 1);
        String ans;
        String corr = null;

        switch (Answers.get(i)) {
            default:
                ans = "Not Attempted";
                break;
            case 1:
                ans = 1 + ". " + optA.get(i);
                break;
            case 2:
                ans = 2 + ". " + optB.get(i);
                break;
            case 3:
                ans = 3 + ". " + optC.get(i);
                break;
            case 4:
                ans = 4 + ". " + optD.get(i);
                break;
        }

        switch (Answer.get(i)) {
            case 1:
                corr = 1 + ". " + optA.get(i);
                break;
            case 2:
                corr = 2 + ". " + optB.get(i);
                break;
            case 3:
                corr = 3 + ". " + optC.get(i);
                break;
            case 4:
                corr = 4 + ". " + optD.get(i);
                break;
        }

        answerViewHolder.question.setText(qus);
        answerViewHolder.answered.setText(ans);
        answerViewHolder.correct.setText(corr);

        if ( Answer.get(i).equals(Answers.get(i)) )
            answerViewHolder.answered.setTextColor(Color.GREEN);
        else
            answerViewHolder.answered.setTextColor(Color.RED);
    }

    @NonNull
    @Override
    public AnswerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new AnswerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.relative, viewGroup, false));
    }


    class AnswerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_question)
        TextView question;

        @BindView(R.id.tv_answered)
        TextView answered;

        @BindView(R.id.tv_correct)
        TextView correct;

        AnswerViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}