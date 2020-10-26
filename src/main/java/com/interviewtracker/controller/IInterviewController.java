package com.interviewtracker.controller;

import org.springframework.http.ResponseEntity;

import com.interviewtracker.dao.InterviewDetailsDAO;
import com.interviewtracker.exception.ValidationException;

public interface IInterviewController {

	public ResponseEntity<?> addInterview(InterviewDetailsDAO interviewDetails) throws ValidationException;

	public ResponseEntity<?> deleteInterview(int id) throws ValidationException;

	public ResponseEntity<?> updateInterviewStatus(int id, String interviewStatus) throws ValidationException;

	public ResponseEntity<?> getInterviewList();

	public ResponseEntity<?> getInterviewCount();

	public ResponseEntity<?> findByInterviewNameAndInterviewerDetails(String interviewName, String interviewerName)
			throws ValidationException;
}
