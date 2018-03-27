package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exam.model.Admin;
import com.exam.model.Exam;
import com.exam.service.ExamService;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(value="/admin/searchquestion")
public class SearchQuestionController {
	@Autowired
	private ExamService examService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showSearchQuestion(Map model,HttpSession session){
		Long userId = Long.parseLong(session.getAttribute("userId").toString());
		   if((session.getAttribute("adminEmail"))==null){
			   Admin admin=new Admin();
			   model.put("admin",admin);
			   return "/admin/adminlogin";
			 }
		   Exam exam=new Exam();
		   model.put("exam", exam);
		   model.put("examlist", examService.listExams());
		   return "/admin/searchquestion";
	 }
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView processSearchQuestion(@Valid Exam exam,Map model,HttpSession session){
		   Long examId = exam.getExamId();
		   Long userId = Long.parseLong(session.getAttribute("userId").toString());
		   if(examId == -1){
			  model.put("examlist", examService.listExams());
			  model.put("errormessage", "Select Exam");
			  return new ModelAndView("admin/searchquestion");
		   }
		   return new ModelAndView("redirect:questionlist.html?examId="+exam.getExamId());
	 }
 }
