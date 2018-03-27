package com.exam.service;

import java.util.List;

import com.exam.model.Exam;

public interface ExamService {
	public List<Exam> listEligibleExams(Long userId);
	
	public List<Exam> listExams();

	public List<Exam> getExamByExamId(Long examId);
	
	public Exam updateExam(Exam exam);
	
	public Exam saveExam(Exam exam);
	
}
