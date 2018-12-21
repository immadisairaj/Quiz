package com.example.immadisairaj.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.example.immadisairaj.quiz.question.Question;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuizActivity extends AppCompatActivity {

    Question qAndA = new Question();

    int ques, score, ans, nextC;
    boolean submit = true;

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

    @BindView(R.id.prev)
    Button prevButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ButterKnife.bind(this);
        qAndA= (Question)getIntent().getExtras().getSerializable("question");
        Intent i=getIntent();
        qAndA=(Question)i.getSerializableExtra("question");
        q_nos = "Question: " + 1 + "/" + qAndA.question.size();
        questions = findViewById(R.id.question);
        questions.setText("Quiz");
        prevButton.setVisibility(View.GONE);
        Answers = new ArrayList<>();

        ques = -1;
        score = 0;
        ans = 0;
        nextC = 0;
        goNext();
    }

    public void clickNext(View view) {

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

        if (ques >= 0) {
            try {
                Answers.set(ques, ans);
            } catch (Exception e) {
                Answers.add(ques, ans);
            }
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
        if (ques > 0)
            prevButton.setVisibility(View.VISIBLE);

        nextC++;
        ans=0;
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

        q_nos = "Question: " + (ques + 1) + "/" + qAndA.question.size();
        q_no.setText(q_nos);
        questions.setText(qAndA.question.get(ques));
        opA.setText(qAndA.optA.get(ques));
        opB.setText(qAndA.optB.get(ques));
        opC.setText(qAndA.optC.get(ques));
        opD.setText(qAndA.optD.get(ques));
        try {
            if (Answers.get(ques) == 1) {
                opA.setChecked(true);
            } else if (Answers.get(ques) == 2) {
                opB.setChecked(true);
            } else if (Answers.get(ques) == 3) {
                opC.setChecked(true);
            } else if (Answers.get(ques) == 4) {
                opD.setChecked(true);
            } else {
                optionsGroup.clearCheck();
            }
        } catch (Exception e) {
            optionsGroup.clearCheck();
        }
    }

    public void checkScore() {
        if (ques != -1)
            for (int i = 0; i < Answers.size(); i++) {
                if (qAndA.Answer.get(i) == Answers.get(i)) {
                    score++;
                }
            }
    }

    public void clickPrev(View view) {

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
        if (ques >= 0) {
            try {
                Answers.set(ques, ans);
            } catch (Exception e) {
                Answers.add(ques, ans);
            }
        }
        if (ques < qAndA.question.size() - 1) {
            goPrev();
        } else if (ques == qAndA.question.size() - 1) {
            Button button = findViewById(R.id.next);
            button.setVisibility(View.VISIBLE);
            button = findViewById(R.id.submit);
            button.setVisibility(View.INVISIBLE);
            optionsGroup.clearCheck();
            goPrev();
        }
        if (ques == 0)
            prevButton.setVisibility(View.GONE);
        nextC--;
        ans = 0;
    }

    public void goPrev() {

        q_no.setVisibility(View.VISIBLE);
        opA.setVisibility(View.VISIBLE);
        opB.setVisibility(View.VISIBLE);
        opC.setVisibility(View.VISIBLE);
        opD.setVisibility(View.VISIBLE);
        ques--;
        q_nos = "Question: " + (ques + 1) + "/" + qAndA.question.size();
        q_no.setText(q_nos);
        questions.setText(qAndA.question.get(ques));
        opA.setText(qAndA.optA.get(ques));
        opB.setText(qAndA.optB.get(ques));
        opC.setText(qAndA.optC.get(ques));
        opD.setText(qAndA.optD.get(ques));
        try {
            if (Answers.get(ques) == 1) {
                opA.setChecked(true);
            } else if (Answers.get(ques) == 2) {
                opB.setChecked(true);
            } else if (Answers.get(ques) == 3) {
                opC.setChecked(true);
            } else if (Answers.get(ques) == 4) {
                opD.setChecked(true);
            } else {
                optionsGroup.clearCheck();
            }
        } catch (Exception e) {
            optionsGroup.clearCheck();

        }
    }

    public void clickSubmit(View view) {
        clickNext(view);

        if(submit)
            checkScore();
        submit = false;

        prevButton.setVisibility(View.INVISIBLE);
        opA.setClickable(false);
        opB.setClickable(false);
        opC.setClickable(false);
        opD.setClickable(false);

        AlertDialog.Builder builder = new AlertDialog.Builder(QuizActivity.this);
        builder.setTitle("Scored " + score + " out of " + qAndA.question.size());
        builder.setPositiveButton("View Solutions", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                clickSolutions();
            }
        });
        builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                System.exit(0);
            }
        });
        AlertDialog scoreDialog = builder.create();
        scoreDialog.show();
    }

    public void clickSolutions() {
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
    @Override
    public void onBackPressed() {
        Toast.makeText(this,"Back Press is not allowed",Toast.LENGTH_LONG).show();
    }
}
