package com.exam.validators;

import org.hibernate.validator.constraints.NotEmpty;

public class AddExamForm {

	// @NotEmpty
	private Long examId;

	private String examName;

	public Long getExamId() {
		return examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}



}
