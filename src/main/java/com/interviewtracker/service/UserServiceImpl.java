package com.interviewtracker.service;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interviewtracker.dao.UserDetailsDAO;
import com.interviewtracker.mapper.UserDetailsMapper;
import com.interviewtracker.model.InterviewDetails;
import com.interviewtracker.model.UserDetails;
import com.interviewtracker.repository.IUserDetailsRepository;

@Service
public class UserServiceImpl  implements IUserService{
	
	@Autowired
	private IUserDetailsRepository userRepository;
	
	public void saveUser(UserDetailsDAO userDetailsDTO) {
		userRepository.save(UserDetailsMapper.mapUserDetails(userDetailsDTO));
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
	
	@ManyToOne
    @JoinColumn(name="interviewId", nullable=false)
	@Override
	public List<UserDetailsDAO> returnUserList() {
		return UserDetailsMapper.mapUserDetailsDtoList(userRepository.findAll());

	}
	
	@Override
	public List<UserDetails> returnUserDetails(int interviewId) {

		return userRepository.findUsersByInterviewId(interviewId);
	}

	
	

}
