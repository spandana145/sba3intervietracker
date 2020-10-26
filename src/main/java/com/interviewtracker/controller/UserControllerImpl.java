package com.interviewtracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interviewtracker.dao.UserDetailsDAO;
import com.interviewtracker.exception.ValidationException;
import com.interviewtracker.service.IUserService;
import com.interviewtracker.validations.InterviewTrackerValidations;

@RestController
@RequestMapping(value = "/user")
public class UserControllerImpl implements IUserController {

	@Autowired
	private IUserService userService;

	@Override
	@PostMapping("/add")
	public ResponseEntity<?> addUser(@RequestBody UserDetailsDAO userDetails) throws ValidationException {

		InterviewTrackerValidations.validateUser(userDetails);
		userService.saveUser(userDetails);
		return ResponseEntity.ok("Successfully added user details");
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") int id) throws ValidationException {

		InterviewTrackerValidations.validateUserId(id);
		userService.deleteUser(id);
		return ResponseEntity.ok("Successfully deleted user details");
	}


	@Override
	@GetMapping("/users")
	public ResponseEntity<?> getUserList() {

		return ResponseEntity.ok(userService.returnUserList());
	}

    @Override
    @GetMapping("/getUsersByInterview/{interviewId}")
    public ResponseEntity<?>findUsersByInterviewId(@PathVariable("interviewId") int interviewId) throws ValidationException{
    	
    	InterviewTrackerValidations.validateInterviewId(interviewId);
    	return ResponseEntity.ok(userService.returnUserDetails(interviewId));
    }

	

}
