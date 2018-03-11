package com.exam.dao.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.dao.LanguageDao;
import com.exam.model.Language;
import com.exam.model.User;

@Repository("languageDao")
public class LanguageDaoImpl implements LanguageDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Language> listLanguages() {
		return (List<Language>) sessionFactory.getCurrentSession()
				.createCriteria(Language.class).list();
	}

	@Override
	public List<Language> getLanguageByLanguageId(Long languageId) {
		return sessionFactory.getCurrentSession().createQuery(
				"from Language where languageId=:languageId").setParameter(
				"languageId", languageId).list();
	}
}
