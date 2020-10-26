package com.interviewtracker.service;

import java.util.List;

import com.interviewtracker.dao.InterviewDetailsDAO;
import com.interviewtracker.exception.ValidationException;
import com.interviewtracker.model.InterviewDetails;

public interface IInterviewService {

	public void saveInterview(InterviewDetailsDAO interviewDetailsdto);

	public void deleteInterview(int id) throws ValidationException ;

	public String updateInterviewStatus(int id, String status);
	
	public List<InterviewDetailsDAO> returnInterviewList();
	
	public long returnInterviewCount();
	
	public InterviewDetails returnInterviewDetails(String interviewName, String interviewerName);
}
