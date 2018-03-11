package com.exam.dao.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.dao.LanguageDao;
import com.exam.model.Language;

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
	
	
	@Override
	public Language saveLanguage(Language language) {
		sessionFactory.getCurrentSession().save(language);
		return language;
	}

	@Override
	public Language updateLanguage(Language language) {
		int result = sessionFactory
				.getCurrentSession()
				.createQuery(
						"UPDATE Language SET lang_name=:lang_name where languageId=:languageId")
				.setParameter("languageId", language.getLanguageId())
				.setParameter("lang_name", language.getLanguageName())
				.executeUpdate();
		if (result > 0) {
			return language;
		}
		
		return language;
	}

}
