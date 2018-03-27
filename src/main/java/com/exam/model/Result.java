package com.exam.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.scheduling.config.Task;


@Entity
@SuppressWarnings("serial")
@Table(name = "result")
public class Result {
	
	@Id
	@GeneratedValue
	@Column(name = "result_id")
	private Long resultid;
	
	
	@Column(name = "user_id")
	private Long userid;
	
	@Column(name = "exam_id")
	private Long examid;
	
	@Column(name = "score")
	private Integer score;
	
	@Column(name = "correct")
	private Integer correct;
	
	@Column(name = "wrong")
	private Integer wrong;
	
	@Column(name = "totalQuestions")
	private Integer totalQuestions;
	
	

	public Integer getTotalQuestions() {
		return totalQuestions;
	}


	public void setTotalQuestions(Integer totalQuestions) {
		this.totalQuestions = totalQuestions;
	}


	public Long getResultid() {
		return resultid;
	}


	public void setResultid(Long resultid) {
		this.resultid = resultid;
	}


	public Long getUserid() {
		return userid;
	}


	public void setUserid(Long userid) {
		this.userid = userid;
	}


	public Long getExamid() {
		return examid;
	}


	public void setExamid(Long examid) {
		this.examid = examid;
	}


	public Integer getScore() {
		return score;
	}


	public void setScore(Integer score) {
		this.score = score;
	}


	public Integer getCorrect() {
		return correct;
	}


	public void setCorrect(Integer correct) {
		this.correct = correct;
	}


	public Integer getWrong() {
		return wrong;
	}


	public void setWrong(Integer wrong) {
		this.wrong = wrong;
	}

}
