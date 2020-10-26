package com.interviewtracker.controller;

import org.springframework.http.ResponseEntity;

import com.interviewtracker.dao.UserDetailsDAO;
import com.interviewtracker.exception.ValidationException;

public interface IUserController {
	
	public ResponseEntity<?> addUser(UserDetailsDAO userDetails) throws ValidationException;

	public ResponseEntity<?> deleteUser(int id) throws ValidationException;

	public ResponseEntity<?> getUserList();

	public ResponseEntity<?> findUsersByInterviewId(int interviewId) throws ValidationException;

}
