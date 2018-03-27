package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exam.model.Exam;
import com.exam.model.User;
import com.exam.service.ExamService;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user/selectpaper")
public class SelectPaperController {
	@Autowired
	private ExamService examService;

	@RequestMapping(method = RequestMethod.GET)
	public String showSelectPaper(Map model, HttpSession session) {
		Long userId = Long.parseLong(session.getAttribute("userId").toString());
		if ((session.getAttribute("userEmail")) == null) {
			User user = new User();
			model.put("user", user);
			return "/user/userlogin";
		}
		Exam exam = new Exam();
		model.put("exam", exam);
		model.put("examlist", examService.listEligibleExams(userId));
		return "/user/selectpaper";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processSelectPaper(@Valid Exam exam, Map model,
			HttpSession session) {
		Long userId = Long.parseLong(session.getAttribute("userId").toString());
		if ((session.getAttribute("userEmail")) == null) {
			return new ModelAndView("redirect:userlogin.html");
		}
		Long examId = exam.getExamId();
		if (examId == -1) {
			model.put("examlist", examService.listExams());
			model.put("errormessage", "Select Exam");
			return new ModelAndView("/user/selectpaper");
		}
		return new ModelAndView("redirect:questionpaper.html?examId="
				+ exam.getExamId());
	}
}
