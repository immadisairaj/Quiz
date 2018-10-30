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

import butterknife.BindView;
import butterknife.ButterKnife;


public class QuestionsFragment extends Fragment {

    @BindView(R.id.rv_questions)
    RecyclerView solutions;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_questions, container, false);

        ButterKnife.bind(this, view);

        QuestionsAdapter questionsAdapter = new QuestionsAdapter(SolutionActivity.getQuestion());
        solutions.setAdapter(questionsAdapter);

        return view;
    }
}