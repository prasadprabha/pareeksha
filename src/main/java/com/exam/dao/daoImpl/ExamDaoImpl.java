package com.exam.dao.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.dao.ExamDao;
import com.exam.model.Exam;

@Repository("examDao")
public class ExamDaoImpl implements ExamDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Exam> listExams() {
		return (List<Exam>) sessionFactory.getCurrentSession()
				.createCriteria(Exam.class).list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Exam> listEligibleExams(Long userId) {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("select ex.exam_id exam_id,ex.exam_name exam_name from exam  ex where exam_id not in (SELECT ex.exam_id  FROM exam ex join result r on ex.exam_id=r.exam_id where user_id = ?)");
		List<Object[]>  examsObjArrayList = query.setLong(0, userId).list();
		List<Exam>  exams = new ArrayList<Exam>();
		for (Object[] examObjArray : examsObjArrayList) {
			Exam exam = new Exam();
			exam.setExamId(Long.parseLong(examObjArray[0].toString()));
			exam.setExamName(examObjArray[1].toString());
			exams.add(exam);
		}
		
		return exams;
		
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
