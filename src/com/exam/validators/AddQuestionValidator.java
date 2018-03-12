package com.exam.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.exam.validators.AddQuestionForm;

@Component("addQuestionValidator")
public class AddQuestionValidator{
	   public boolean supports(Class<?> klass){
		      return AddQuestionForm.class.isAssignableFrom(klass);
		 }
	   
	   public void validate(Object target, Errors errors){
		      AddQuestionForm addQuestionForm = (AddQuestionForm) target;
		      if(addQuestionForm.getExamId()==-1){
		    	  errors.rejectValue("examId","NotEmpty.addQuestionForm.examId","Select Exam.");
		       }
		      if(addQuestionForm.getRightOption()==null){
		    	  errors.rejectValue("rightOption","selectRightAnswer.addQuestionForm.rightOption","Select Right Answer.");
		       }
	   }
  }
