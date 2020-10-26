package com.interviewtracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "interview_details")
public class InterviewDetails {

	@Id
	@Column
	private int interviewId;
	@Column
	private String interviewerName;
	@Column
	private String interviewName;
	@Column
	private String usersSkills;
	@Column
	private String date;
	@Column
	private String time;
	@Column
	private String interviewStatus;
	@Column
	private String remarks;
	
	public int getInterviewId() {
		return interviewId;
	}
	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
	}
	public String getInterviewerName() {
		return interviewerName;
	}
	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}
	public String getInterviewName() {
		return interviewName;
	}
	public void setInterviewName(String interviewName) {
		this.interviewName = interviewName;
	}
	public String getUsersSkills() {
		return usersSkills;
	}
	public void setUsersSkills(String usersSkills) {
		this.usersSkills = usersSkills;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getInterviewStatus() {
		return interviewStatus;
	}
	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
	
}
