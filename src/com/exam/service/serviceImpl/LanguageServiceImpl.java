package com.exam.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.exam.dao.LanguageDao;
import com.exam.model.Language;
import com.exam.service.LanguageService;

@Service("languageService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LanguageServiceImpl implements LanguageService {
	@Autowired
	private LanguageDao languageDao;
	
	public List<Language> listLanguages(){		   
		   return languageDao.listLanguages();	 
	 }
	
	public List<Language> getLanguageByLanguageId(Long languageId){
		   return languageDao.getLanguageByLanguageId(languageId);
	 }

}
