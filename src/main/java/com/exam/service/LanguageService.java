package com.exam.service;

import java.util.List;

import com.exam.model.Language;

public interface LanguageService {
	public List<Language> listLanguages();

	public List<Language> getLanguageByLanguageId(Long languageId);
	
	public Language updateLanguage(Language language);
	
	public Language saveLanguage(Language language);
	
}
