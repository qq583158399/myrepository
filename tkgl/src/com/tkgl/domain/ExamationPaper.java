package com.tkgl.domain;

import java.sql.Timestamp;

public class ExamationPaper {
	private int examationPaperId;
	private String examationPaperName;
	private String examationPaperQuestionIds;
	private Timestamp createTime;
	
	public int getExamationPaperId() {
		return examationPaperId;
	}
	public void setExamationPaperId(int examationPaperId) {
		this.examationPaperId = examationPaperId;
	}
	public String getExamationPaperName() {
		return examationPaperName;
	}
	public void setExamationPaperName(String examationPaperName) {
		this.examationPaperName = examationPaperName;
	}
	public String getExamationPaperQuestionIds() {
		return examationPaperQuestionIds;
	}
	public void setExamationPaperQuestionIds(String examationPaperQuestionIds) {
		this.examationPaperQuestionIds = examationPaperQuestionIds;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
		
}
