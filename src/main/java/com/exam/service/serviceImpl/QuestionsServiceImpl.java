package com.exam.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.exam.dao.QuestionsDao;
import com.exam.model.Questions;
import com.exam.service.QuestionsService;

@Service("questionsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class QuestionsServiceImpl implements QuestionsService {
   
	@Autowired
	private QuestionsDao questionsDao;
	
	@Override
	public List<Questions> listQuestions(){
		   return questionsDao.listQuestions();		
	 }
	
	@Override
	public List<Questions> getQuestionsByExamId(Long examId){
		   return questionsDao.getQuestionsByExamId(examId);		
	  }
	
	@Override
	public List<Questions> getQuestionsByQuestionId(Long questionId){
		   return questionsDao.getQuestionsByQuestionId(questionId);
	    }
	
	@Override
	public void saveQuestions(Questions questions){
		   questionsDao.saveQuestions(questions);
	 }
	
	@Override
	public void updateQuestions(Questions questions){
		   questionsDao.updateQuestions(questions);
	 }
	
	@Override
	public void deleteQuestions(Questions questions){
		questionsDao.deleteQuestions(questions); 
	 }
	
	@Override
	public List<Questions> getTenRandomQuestionsByExamId(Long examId){
		return questionsDao.getTenRandomQuestionsByExamId(examId);  
	 }
}
