package com.exam.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exam.model.Admin;
import com.exam.model.Language;
import com.exam.service.LanguageService;
import com.exam.validators.AddExamForm;
import com.exam.validators.AddQuestionForm;

@Controller
@RequestMapping("/admin/addexam")
public class AddExamController {
	@Autowired
	private LanguageService languageService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showAddExamForm(Map model, HttpServletRequest request,
			HttpSession session) {
		
		String pageHeading = "Add Exam Details";
		AddExamForm addExamForm = new AddExamForm();
		
		
		if ((session.getAttribute("adminEmail")) == null) {
			Admin admin = new Admin();
			model.put("admin", admin);
			return "/admin/adminlogin";
		}
		
		model.put("pageHeading", pageHeading);
		model.put("addExamForm", addExamForm);
		return "/admin/addexam";
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addExam(
			@Valid AddExamForm addExamForm, BindingResult result,
			Map model, HttpSession session) {
		
		Language language = new Language();
		language.setLanguageName(addExamForm.getLanguageName());
		language.setLanguageId(addExamForm.getLanguageId());
		if(StringUtils.isEmpty(addExamForm.getLanguageId())) {
			languageService.saveLanguage(language);
		} else {
			languageService.updateLanguage(language);
		}
		addExamForm.setLanguageId(language.getLanguageId());
		addExamForm.setLanguageName(language.getLanguageName());
		return new ModelAndView("/admin/addexam");
		//return new ModelAndView("redirect:questionlist.html");
	}
	
	
}