package com.exam.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.exam.dao.ExamDao;
import com.exam.model.Exam;
import com.exam.service.ExamService;

@Service("examService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ExamServiceImpl implements ExamService {
	@Autowired
	private ExamDao examDao;
	
	public List<Exam> listExams(){		   
		   return examDao.listExams();	 
	 }
	
	public List<Exam> listEligibleExams(Long userId) {
		return examDao.listEligibleExams(userId);
	}
	
	public List<Exam> getExamByExamId(Long examId){
		   return examDao.getExamByExamId(examId);
	 }

	
	@Override
	public Exam updateExam(Exam exam) {
		 return examDao.updateExam(exam);
	}
	
	public Exam saveExam(Exam exam) {
		return examDao.saveExam(exam);
	}
}
