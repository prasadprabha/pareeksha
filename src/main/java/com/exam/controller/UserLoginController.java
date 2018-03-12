package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exam.model.User;
import com.exam.service.AdminService;
import com.exam.service.UserService;
import com.exam.validators.AdminLoginValidator;
import com.exam.validators.UserLoginValidator;

import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user/userlogin")
public class UserLoginController {

	@Autowired
	private UserLoginValidator userLoginValidator;
	@Autowired
	private UserService userService;
	
	@Autowired
	private AdminLoginValidator adminLoginValidator;
	@Autowired
	private AdminService adminService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showUserLogin(Map model, HttpSession session) {
		if (session.getAttribute("userEmail") == null) {
			User user = new User();
			model.put("user", user);
			return new ModelAndView("/user/userlogin");
		} else {
			return new ModelAndView("redirect:selectpaper.html");
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processUserLogin(@Valid User user,
			BindingResult result, Map model, HttpSession session) {
		
		userLoginValidator.validate(user, result);
		if (result.hasErrors()) {
			return new ModelAndView("/user/userlogin");
		}
		List userlist = userService.getUserByUserEmail(user.getUserEmail());
		if (userlist != null && userlist.size() > 0) {
			User user1 = new User();
			user1 = (User) userlist.get(0);
			session.setAttribute("userName", user1.getUserName());
			if(user1.getUserName().equals("admin")) {
				session.setAttribute("adminEmail", user.getUserEmail());
				return new ModelAndView("redirect:/forms/admin/addquestion.html");
			} else {
				session.setAttribute("userEmail", user.getUserEmail());
				return new ModelAndView("redirect:selectpaper.html");
			}
		} else {
			return new ModelAndView("/user/userlogin");
		}
		
		
		
	}
}
