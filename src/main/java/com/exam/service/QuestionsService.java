package com.exam.service;

import java.util.List;

import com.exam.model.Questions;

public interface QuestionsService {
	public List<Questions> listQuestions();

	public List<Questions> getQuestionsByExamId(Long examId);

	public List<Questions> getQuestionsByQuestionId(Long questionId);

	public void saveQuestions(Questions questions);

	public void updateQuestions(Questions questions);

	public void deleteQuestions(Questions questions);

	public List<Questions> getTenRandomQuestionsByExamId(Long examId);

}
