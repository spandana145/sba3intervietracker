package com.interviewtracker.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.interviewtracker.model.UserDetails;

public interface IUserDetailsRepository extends CrudRepository<UserDetails, Integer> {

	public List<UserDetails> findUsersByInterviewId(int interviewId);
}


