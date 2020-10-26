package com.interviewtracker.repository;

import org.springframework.data.repository.CrudRepository;

import com.interviewtracker.model.InterviewDetails;

public interface IInterviewDetailsRepository extends CrudRepository<InterviewDetails, Integer> {

	public InterviewDetails findByInterviewNameAndInterviewerName(String interviewName, String interviewerName);
}
