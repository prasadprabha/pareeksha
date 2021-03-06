package com.exam.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.exam.dao.QuestionOptionsDao;
import com.exam.model.QuestionOptions;
import com.exam.service.QuestionOptionsService;

@Service("questionOptionsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class QuestionOptionsServiceImpl implements QuestionOptionsService {
   
	@Autowired
	private QuestionOptionsDao questionOptionsDao;
	
	@Override
	public List<QuestionOptions> listQuestionOptions() {
		return questionOptionsDao.listQuestionOptions();		
	 }
	
	@Override
	public List<QuestionOptions> getQuestionOptionsByQuestionId(Long questionId){
	       return questionOptionsDao.getQuestionOptionsByQuestionId(questionId);		
	 }
	
	@Override
	public List<QuestionOptions> getQuestionOptionsByQuesOpId(Long quesOpId){
	       return questionOptionsDao.getQuestionOptionsByQuesOpId(quesOpId);		
	 }
	
	@Override
	public void saveQuestionOptions(QuestionOptions questionOptions){
		   questionOptionsDao.saveQuestionOptions(questionOptions);
	 }
	
	@Override
	public void updateQuestionOptions(QuestionOptions questionOptions){
		questionOptionsDao.updateQuestionOptions(questionOptions);
	 }
	
	@Override
	public void deleteQuestionOptionsByQuestionId(Long questionId){
		   questionOptionsDao.deleteQuestionOptionsByQuestionId(questionId);
	 }
	
	
}
