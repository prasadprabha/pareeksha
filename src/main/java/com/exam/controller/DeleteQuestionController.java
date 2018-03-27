package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exam.model.Admin;
import com.exam.model.Questions;
import com.exam.service.ExamService;
import com.exam.service.QuestionOptionsService;
import com.exam.service.QuestionsService;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/admin/deletequestion")
public class DeleteQuestionController {
	@Autowired
	private ExamService examService;
	@Autowired
	private QuestionsService questionsService;
	@Autowired
	private QuestionOptionsService questionOptionsService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showDeleteQuestion(Map model,
			HttpServletRequest request, HttpSession session) {
		Long userId = Long.parseLong(session.getAttribute("userId").toString());
		if ((session.getAttribute("adminEmail")) == null) {
			// Admin admin=new Admin();
			// model.put("admin",admin);
			// return "/admin/adminlogin";
			return new ModelAndView("redirect:adminlogin.html");
		}
		model.put("examlist", examService.listExams());
		String questionIdInString = request.getParameter("questionId");
		if (questionIdInString != null && (!questionIdInString.equals(""))) {
			Questions questions = new Questions();
			questions.setQuestionId(Long.parseLong(questionIdInString));
			questionsService.deleteQuestions(questions);
			questionOptionsService.deleteQuestionOptionsByQuestionId(Long
					.parseLong(questionIdInString));
		}
		return new ModelAndView("redirect:questionlist.html?examId="
				+ request.getParameter("examId"));
	}
}
