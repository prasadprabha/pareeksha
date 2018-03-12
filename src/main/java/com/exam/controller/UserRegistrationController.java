package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;

import com.exam.model.User;
import com.exam.service.UserService;
import com.exam.utils.Encryption;
import com.exam.validators.UserForm;
import com.exam.validators.UserRegistrationValidator;

import java.util.Map;

import javax.validation.Valid;

@Controller
@RequestMapping("/user/userregistration")
public class UserRegistrationController {

	@Autowired
	private UserService userService;

	@Autowired
	UserRegistrationValidator userRegistrationValidator;

	@RequestMapping(method = RequestMethod.GET)
	public String showUserLogin(Map model) {
		UserForm userForm = new UserForm();
		model.put("userForm", userForm);
		return "/user/userregistration";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processUserLogin(@Valid UserForm userForm,
			BindingResult result, Map model) {
		userRegistrationValidator.validate(userForm, result);

		if (result.hasErrors()) {
			return new ModelAndView("/user/userregistration");
		} else {

			// set userForm value to user object.
			User user = new User();
			user.setUserName(userForm.getUserName());
			user.setUserEmail(userForm.getUserEmail());
			user.setPassword(Encryption.encrypt(userForm.getPassword()));
			user.setUserGender(userForm.getUserGender());
			user.setPhoneNo(userForm.getPhoneNo());
			user.setAddress(userForm.getAddress());

			userService.saveUser(user);
		}
		return new ModelAndView("redirect:userlogin.html");
	}
}
