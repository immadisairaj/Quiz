package com.example.immadisairaj.quiz;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Question {

    Context context;
    Activity activity;

    List<Result> results;

    public List<String> question;
    public List<String> optA;
    public List<String> optB;
    public List<String> optC;
    public List<String> optD;
    public List<Integer> Answer;

    public void setQuestion(Context context, Activity activity) {

        this.context = context;
        this.activity = activity;

        question = new ArrayList<>();
        optA = new ArrayList<>();
        optB = new ArrayList<>();
        optC = new ArrayList<>();
        optD = new ArrayList<>();
        Answer = new ArrayList<>();

        fetchApi();


    }

    public void fetchApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Call<QuizQuestions> call = api.getQuizQuestions("url3986", 10, "medium", "multiple");

        call.enqueue(new Callback<QuizQuestions>() {
            @Override
            public void onResponse(Call<QuizQuestions> call, Response<QuizQuestions> response) {

                Log.v("url", call.request().url().toString());

                View loadingIndicator = activity.findViewById(R.id.loading_indicator);
                loadingIndicator.setVisibility(View.INVISIBLE);

                QuizQuestions quizQuestions = response.body();

                if (quizQuestions.getResponseCode() == 0) {

                    results = quizQuestions.getResults();

                    if (results != null) {
                        for (Result r : results) {
                            try {
                                question.add(java.net.URLDecoder.decode(r.getQuestion(), "UTF-8"));
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }

                            Random random = new Random();
                            int ran = random.nextInt(4);
                            setOptions(r, ran);

                            Answer.add(ran+1);
                        }
                        Log.v("answers", Answer.toString());
                    }
                }

            }

            @Override
            public void onFailure(Call<QuizQuestions> call, Throwable t) {
                Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void setOptions(Result r, int ran) {
        List<String> wrong;
        switch (ran) {
            case 0:
                try {
                    optA.add(java.net.URLDecoder.decode(r.getCorrectAnswer(), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                wrong = r.getIncorrectAnswers();
                try {
                    optB.add(java.net.URLDecoder.decode(wrong.get(0), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                try {
                    optC.add(java.net.URLDecoder.decode(wrong.get(1), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                try {
                    optD.add(java.net.URLDecoder.decode(wrong.get(2), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            case 1:
                try {
                    optB.add(java.net.URLDecoder.decode(r.getCorrectAnswer(), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                wrong = r.getIncorrectAnswers();
                try {
                    optA.add(java.net.URLDecoder.decode(wrong.get(0), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                try {
                    optC.add(java.net.URLDecoder.decode(wrong.get(1), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                try {
                    optD.add(java.net.URLDecoder.decode(wrong.get(2), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    optC.add(java.net.URLDecoder.decode(r.getCorrectAnswer(), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                wrong = r.getIncorrectAnswers();
                try {
                    optA.add(java.net.URLDecoder.decode(wrong.get(0), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                try {
                    optB.add(java.net.URLDecoder.decode(wrong.get(1), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                try {
                    optD.add(java.net.URLDecoder.decode(wrong.get(2), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    optD.add(java.net.URLDecoder.decode(r.getCorrectAnswer(), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                wrong = r.getIncorrectAnswers();
                try {
                    optA.add(java.net.URLDecoder.decode(wrong.get(0), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                try {
                    optB.add(java.net.URLDecoder.decode(wrong.get(1), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                try {
                    optC.add(java.net.URLDecoder.decode(wrong.get(2), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
