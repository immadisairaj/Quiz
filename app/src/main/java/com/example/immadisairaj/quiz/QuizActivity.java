package com.example.immadisairaj.quiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuizActivity extends AppCompatActivity {

    Question qAndA = new Question();

    int ques, score, ans, nextC;

    ArrayList<Integer> Answers;


    String q_nos;

    @BindView(R.id.q_numbers)
    TextView q_no;

    @BindView(R.id.question)
    TextView questions;

    @BindView(R.id.optionA)
    RadioButton opA;

    @BindView(R.id.optionB)
    RadioButton opB;

    @BindView(R.id.optionC)
    RadioButton opC;

    @BindView(R.id.optionD)
    RadioButton opD;

    @BindView(R.id.options)
    RadioGroup optionsGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ButterKnife.bind(this);

        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.VISIBLE);
        qAndA.setQuestion(this, this);
        q_nos = "Question: " + 1 + " out of " + qAndA.question.size();

        q_no.setVisibility(View.GONE);
        questions = findViewById(R.id.question);
        questions.setText("Quiz");
        opA.setVisibility(View.GONE);
        opB.setVisibility(View.GONE);
        opC.setVisibility(View.GONE);
        opD.setVisibility(View.GONE);

        Answers = new ArrayList<>();

        ques = -1;
        score = 0;
        ans = 0;
        nextC = 0;
    }

    public void goNext() {

        q_no.setVisibility(View.VISIBLE);
        opA.setVisibility(View.VISIBLE);
        opB.setVisibility(View.VISIBLE);
        opC.setVisibility(View.VISIBLE);
        opD.setVisibility(View.VISIBLE);
        ques++;

        if (ques >= qAndA.question.size()) {
            ques = qAndA.question.size() - 1;
        }

        q_nos = "Question: " + (ques + 1) + " out of " + qAndA.question.size();
        q_no.setText(q_nos);
        questions.setText(qAndA.question.get(ques));
        opA.setText(qAndA.optA.get(ques));
        opB.setText(qAndA.optB.get(ques));
        opC.setText(qAndA.optC.get(ques));
        opD.setText(qAndA.optD.get(ques));
    }

    public void checkScore() {
        if (ques != -1)
            if (qAndA.Answer.get(ques) == ans) {
                score++;
                ans = 0;
            }
    }

    public void clickNext(View view) {
        nextC++;

        int selectedId = optionsGroup.getCheckedRadioButtonId();

        switch (selectedId) {
            case R.id.optionA:
                ans = 1;
                break;
            case R.id.optionB:
                ans = 2;
                break;
            case R.id.optionC:
                ans = 3;
                break;
            case R.id.optionD:
                ans = 4;
                break;
            default:
                ans = 0;
        }
        Answers.add(ans);
        if (nextC <= qAndA.question.size()) {
            checkScore();
        }
        if (ques < qAndA.question.size() - 2) {
            optionsGroup.clearCheck();
            goNext();
        } else if (ques == qAndA.question.size() - 2) {
            Button button = findViewById(R.id.next);
            button.setVisibility(View.INVISIBLE);
            button = findViewById(R.id.submit);
            button.setVisibility(View.VISIBLE);
            optionsGroup.clearCheck();
            goNext();
        }
    }

    public void clickSubmit(View view) {
        clickNext(view);

        Context context = getApplicationContext();
        CharSequence text = "Scored " + score + " out of " + qAndA.question.size();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Button submit = findViewById(R.id.submit);
        submit.setVisibility(View.INVISIBLE);

        Button ans = findViewById(R.id.b_solution);
        ans.setVisibility(View.VISIBLE);
    }

    public void clickSolutions(View view) {
        Intent solutions = new Intent(this, SolutionActivity.class);
        solutions.putIntegerArrayListExtra("Answer", Answers);
        solutions.putStringArrayListExtra("Question", (ArrayList<String>) qAndA.question);
        solutions.putStringArrayListExtra("optA", (ArrayList<String>) qAndA.optA);
        solutions.putStringArrayListExtra("optB", (ArrayList<String>) qAndA.optB);
        solutions.putStringArrayListExtra("optC", (ArrayList<String>) qAndA.optC);
        solutions.putStringArrayListExtra("optD", (ArrayList<String>) qAndA.optD);
        solutions.putIntegerArrayListExtra("Answers", (ArrayList<Integer>) qAndA.Answer);
        startActivity(solutions);
    }
}