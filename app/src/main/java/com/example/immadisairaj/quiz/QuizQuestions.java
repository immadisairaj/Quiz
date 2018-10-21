package com.example.immadisairaj.quiz;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuizQuestions {

    @SerializedName("response_code")
    @Expose
    private Integer responseCode;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;


    public QuizQuestions() {
    }

    public QuizQuestions(Integer responseCode, List<Result> results) {
        super();
        this.responseCode = responseCode;
        this.results = results;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public List<Result> getResults() {
        return results;
    }

}