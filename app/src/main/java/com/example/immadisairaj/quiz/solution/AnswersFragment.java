package com.example.immadisairaj.quiz.solution;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.immadisairaj.quiz.R;
import com.example.immadisairaj.quiz.SolutionActivity;
import com.example.immadisairaj.quiz.question.Question;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AnswersFragment extends Fragment {

    @BindView(R.id.rv_answers)
    RecyclerView solutions;

    Question q;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_answers, container, false);

        ButterKnife.bind(this, view);

        ArrayList<Integer> Answers = SolutionActivity.getAnswer();

        AnswerAdapter answerAdapter = new AnswerAdapter(Answers,
                SolutionActivity.getAnswers(),
                SolutionActivity.getOptA(),
                SolutionActivity.getOptB(),
                SolutionActivity.getOptC(),
                SolutionActivity.getOptD());
        solutions.setAdapter(answerAdapter);

        return view;
    }
}