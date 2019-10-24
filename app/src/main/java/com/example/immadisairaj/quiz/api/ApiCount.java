package com.example.immadisairaj.quiz.api;
import com.google.gson.annotations.SerializedName;

public class ApiCount {

	@SerializedName("category_id")
	private int categoryId;

	@SerializedName("category_question_count")
	private CategoryQuestionCount categoryQuestionCount;

	public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
	}

	public int getCategoryId(){
		return categoryId;
	}

	public void setCategoryQuestionCount(CategoryQuestionCount categoryQuestionCount){
		this.categoryQuestionCount = categoryQuestionCount;
	}

	public CategoryQuestionCount getCategoryQuestionCount(){
		return categoryQuestionCount;
	}
}