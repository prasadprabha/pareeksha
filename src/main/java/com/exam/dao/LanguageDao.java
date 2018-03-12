package com.exam.dao;

import java.util.List;

import com.exam.model.Language;

public interface LanguageDao {
	public List<Language> listLanguages();

	public List<Language> getLanguageByLanguageId(Long languageId);
	
	public Language updateLanguage(Language language);
	
	public Language saveLanguage(Language language);
}
