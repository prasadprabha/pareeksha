package com.exam.dao.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.dao.ExamDao;
import com.exam.model.Exam;

@Repository("examDao")
public class ExamDaoImpl implements ExamDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Exam> listExams() {
		return (List<Exam>) sessionFactory.getCurrentSession()
				.createCriteria(Exam.class).list();
	}

	@Override
	public List<Exam> getExamByExamId(Long examId) {
		return sessionFactory.getCurrentSession().createQuery(
				"from Exam where examId=:examId").setParameter(
				"examId", examId).list();
	}
	
	
	@Override
	public Exam saveExam(Exam exam) {
		sessionFactory.getCurrentSession().save(exam);
		return exam;
	}

	@Override
	public Exam updateExam(Exam exam) {
		int result = sessionFactory
				.getCurrentSession()
				.createQuery(
						"UPDATE Exam SET exam_name=:exam_name where examId=:examId")
				.setParameter("examId", exam.getExamId())
				.setParameter("exam_name", exam.getExamName())
				.executeUpdate();
		if (result > 0) {
			return exam;
		}
		
		return exam;
	}

}
