package com.interviewtracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interviewtracker.dao.InterviewDetailsDAO;
import com.interviewtracker.exception.ValidationException;
import com.interviewtracker.service.IInterviewService;
import com.interviewtracker.validations.InterviewTrackerValidations;

@RestController
@RequestMapping(value = "/interview")
public class InterviewControllerImpl implements IInterviewController {

	@Autowired
	private IInterviewService interviewService;

	@Override
	@PostMapping("/add")
	public ResponseEntity<?> addInterview(@RequestBody InterviewDetailsDAO interviewDetails) throws ValidationException {

		InterviewTrackerValidations.validateInterview(interviewDetails);
		interviewService.saveInterview(interviewDetails);
		return ResponseEntity.ok("Successfully added interview details");
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteInterview(@PathVariable("id") int id) throws ValidationException {

		InterviewTrackerValidations.validateInterviewId(id);
		interviewService.deleteInterview(id);
		return ResponseEntity.ok("Successfully deleted interview details");
	}

	@Override
	@PutMapping("/interview-id/{id}/interview-status/{status}")
	public ResponseEntity<?> updateInterviewStatus(@PathVariable("id") int id,
			@PathVariable("status") String interviewStatus) throws ValidationException {

		InterviewTrackerValidations.validateInterviewId(id);
		InterviewTrackerValidations.validateInterviewStatus(interviewStatus);
		interviewService.updateInterviewStatus(id, interviewStatus);
		return ResponseEntity.ok(interviewService.updateInterviewStatus(id, interviewStatus));
	}

	@Override
	@GetMapping("/interviews")
	public ResponseEntity<?> getInterviewList() {

		return ResponseEntity.ok(interviewService.returnInterviewList());
	}

	@Override
	@GetMapping("/interview-count")
	public ResponseEntity<?> getInterviewCount() {

		return ResponseEntity.ok(interviewService.returnInterviewCount());
	}

	@Override
	@GetMapping("/interview-name/{interviewName}/interviewer-name/{interviewerName}")
	public ResponseEntity<?> findByInterviewNameAndInterviewerDetails(
			@PathVariable("interviewName") String interviewName,
			@PathVariable("interviewerName") String interviewerName) throws ValidationException {

		InterviewTrackerValidations.validateIntervieName(interviewName);
		InterviewTrackerValidations.validateInterviewerName(interviewerName);
		return ResponseEntity.ok(interviewService.returnInterviewDetails(interviewName, interviewerName));
	}

}
