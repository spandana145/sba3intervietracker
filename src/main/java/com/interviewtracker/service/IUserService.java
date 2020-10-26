package com.interviewtracker.service;

import java.util.List;

import com.interviewtracker.dao.UserDetailsDAO;
import com.interviewtracker.model.UserDetails;

public interface IUserService {

	public void saveUser(UserDetailsDAO userDetailsdto);

	public void deleteUser(int id);

	
	public List<UserDetailsDAO> returnUserList();
	
	public List<UserDetails> returnUserDetails(int interviewId);
	
	

}
