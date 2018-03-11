package com.exam.dao;

import java.util.List;

import com.exam.model.QuestionOptions;
import com.exam.model.Questions;

public interface QuestionOptionsDao {

	public List<QuestionOptions> listQuestionOptions();

	public List<QuestionOptions> getQuestionOptionsByQuestionId(Long questionId);

	public List<QuestionOptions> getQuestionOptionsByQuesOpId(Long quesOpId);

	public void saveQuestionOptions(QuestionOptions questionOptions);

	public void updateQuestionOptions(QuestionOptions questionOptions);

	public void deleteQuestionOptionsByQuestionId(Long questionId);
}
