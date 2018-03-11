package com.exam.validators;

import org.hibernate.validator.constraints.NotEmpty;

public class AddExamForm {

	// @NotEmpty
	private Long languageId;

	private String languageName;

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public Long getLanguageId() {
		return languageId;
	}

}
