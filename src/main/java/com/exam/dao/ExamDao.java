package com.exam.dao;

import java.util.List;

import com.exam.model.Exam;

public interface ExamDao {
	public List<Exam> listExams();

	public List<Exam> getExamByExamId(Long examId);
	
	public Exam updateExam(Exam exam);
	
	public Exam saveExam(Exam exam);
}
