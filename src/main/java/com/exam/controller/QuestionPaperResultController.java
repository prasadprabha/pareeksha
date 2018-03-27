package com.exam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exam.model.QuestionOptions;
import com.exam.model.Questions;
import com.exam.model.Result;
import com.exam.model.User;
import com.exam.service.QuestionOptionsService;
import com.exam.service.QuestionsService;
import com.exam.validators.QuestionPaperCommand;

import java.util.Map;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user/questionpaperresult")
public class QuestionPaperResultController {

	@Autowired
	private QuestionsService questionsService;
	@Autowired
	private QuestionOptionsService questionOptionsService;

	@RequestMapping(method = RequestMethod.GET)
	public String showQuestionPaperResult(Map model, HttpSession session) {
		if ((session.getAttribute("userEmail")) == null) {
			User user = new User();
			model.put("user", user);
			return "/user/userlogin";
		}
		List<QuestionPaperCommand> questionPaperList = new ArrayList<QuestionPaperCommand>();
		List<Long> questonIdList = (List) session.getAttribute("questonIdList");

		List<Questions> questionlist = new ArrayList<Questions>();
		for (int i = 0; i < questonIdList.size(); i++) {
			Long questionId = questonIdList.get(i);
			questionlist = questionsService
					.getQuestionsByQuestionId(questionId);
			if (questionlist != null && questionlist.size() > 0) {
				for (int j = 0; j < questionlist.size(); j++) {
					QuestionPaperCommand questionPaperCommand = new QuestionPaperCommand();
					List questionOptionsList = new ArrayList();
					Questions questions = new Questions();
					questions = (Questions) questionlist.get(j);
					questionPaperCommand.setExamId(questions.getExamId());
					questionPaperCommand.setQuestionId(questions
							.getQuestionId());
					questionPaperCommand.setQuestion(questions.getQuestion());
					// questionOptionsList
					questionOptionsList = questionOptionsService
							.getQuestionOptionsByQuesOpId(questions
									.getRightOption());
					if (questionOptionsList != null
							&& questionOptionsList.size() > 0) {
						QuestionOptions questionOptions = (QuestionOptions) questionOptionsList
								.get(0);
						questionPaperCommand.setOption1(questionOptions
								.getAnsDescription());

					}
					questionPaperList.add(questionPaperCommand);
				}
			}
		}
		
		
		Integer correctAnswer = Integer.parseInt(session.getAttribute("rightAnswer").toString());
		Integer wongAnswer = Integer.parseInt(session.getAttribute("wongAnswer").toString());
		Long userId = Long.parseLong(session.getAttribute("userId").toString());
		
		Result result = new Result();
		result.setCorrect(correctAnswer);
		result.setWrong(wongAnswer);
		result.setScore(correctAnswer*1);
		result.setTotalQuestions(questionPaperList.size());
		result.setExamid(questionPaperList.get(0).getExamId());
		result.setUserid(userId);
		questionsService.saveResult(result);

		model.put("questionPaperList", questionPaperList);
		model.put("totalQuestion", session.getAttribute("totalQuestion"));
		model.put("rightAnswer", session.getAttribute("rightAnswer"));
		model.put("wongAnswer", session.getAttribute("wongAnswer"));

		session.removeAttribute("totalQuestion");
		session.removeAttribute("rightAnswer");
		session.removeAttribute("wongAnswer");

		return "/user/questionpaperresult";
	}

}
