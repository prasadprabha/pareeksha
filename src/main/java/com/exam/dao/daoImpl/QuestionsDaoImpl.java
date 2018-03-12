package com.exam.dao.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.dao.QuestionsDao;
import com.exam.model.Questions;

@Repository("questionsDao")
public class QuestionsDaoImpl implements QuestionsDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Questions> listQuestions() {
		return (List<Questions>) sessionFactory.getCurrentSession()
				.createCriteria(Questions.class).addOrder(
						Order.desc("questionId")).list();
	}

	@Override
	public List<Questions> getQuestionsByExamId(Long examId) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Questions where examId=:examId ORDER BY questionId DESC")
				.setParameter("examId", examId).list();
	}

	@Override
	public List<Questions> getQuestionsByQuestionId(Long questionId) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Questions where questionId=:questionId ORDER BY questionId DESC")
				.setParameter("questionId", questionId).list();
	}

	public void saveQuestions(Questions questions) {
		sessionFactory.getCurrentSession().save(questions);
	}

	@Override
	public void updateQuestions(Questions questions) {
		sessionFactory
				.getCurrentSession()
				.createQuery(
						"UPDATE Questions SET examId=:examId ,question=:question , rightOption=:rightOption where questionId=:questionId")
				.setParameter("examId", questions.getExamId())
				.setParameter("question", questions.getQuestion())
				.setParameter("rightOption", questions.getRightOption())
				.setParameter("questionId", questions.getQuestionId())
				.executeUpdate();
	}

	@Override
	public void deleteQuestions(Questions questions) {
		sessionFactory.getCurrentSession().createQuery(
				"delete from Questions where questionId=:questionId")
				.setParameter("questionId", questions.getQuestionId())
				.executeUpdate();
	}

	@Override
	public List<Questions> getTenRandomQuestionsByExamId(Long examId) {
		return (List<Questions>) sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Questions where examId=:examId order by rand()")
				.setParameter("examId", examId).setMaxResults(10)
				.list();
	}

}
