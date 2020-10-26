package com.interviewtracker.validations;

import org.springframework.util.StringUtils;

import com.interviewtracker.dao.InterviewDetailsDAO;
import com.interviewtracker.dao.UserDetailsDAO;
import com.interviewtracker.exception.ValidationException;

public class InterviewTrackerValidations {

	public static void validateUser(UserDetailsDAO userDetails) throws ValidationException {
		validateUserId(userDetails.getUserId());
		validatefirstName(userDetails.getFirstName());
		validateLastName(userDetails.getLastName());
		validateEmail(userDetails.getEmail());
		ValidateMobile(userDetails.getMobile());
	}

	public static void validateUserId(int userId) throws ValidationException {
		if (userId == 0)
			throw new ValidationException("User id can't be null");
	}

	public static void validateInterview(InterviewDetailsDAO interviewDetails) throws ValidationException {
		validateInterviewId(interviewDetails.getInterviewId());
		validateInterviewerName(interviewDetails.getInterviewerName());
		validateIntervieName(interviewDetails.getInterviewName());
		validateUserSkills(interviewDetails.getUsersSkills());
		validateInterviewStatus(interviewDetails.getInterviewStatus());
		validateRemarks(interviewDetails.getRemarks());
	}

	public static void validateInterviewId(int interviewId) throws ValidationException {
		if (interviewId == 0)
			throw new ValidationException("Interview id can't be null");
	}

	public static void validatefirstName(String firstName) throws ValidationException {
		if (StringUtils.isEmpty(firstName))
			throw new ValidationException("First name can't be null");
		if (firstName.length() < 5 || firstName.length() > 30)
			throw new ValidationException(
					"First name length is invalid. Please make sure the length is between 5 and 30");
	}
	
	public static void validateLastName(String lastName) throws ValidationException {
		if (StringUtils.isEmpty(lastName))
			throw new ValidationException("Last name can't be null");
		if (lastName.length() < 3 || lastName.length() > 25)
			throw new ValidationException(
					"Last name length is invalid. Please make sure the length is between 5 and 30");
	}

	public static void validateEmail(String email) throws ValidationException {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if (!email.matches(regex))
			throw new ValidationException("Email id is invalid. Please check your email id");
	}

	public static void ValidateMobile(String mobile) throws ValidationException {
		String regex = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$";
		if (!mobile.matches(regex))
			throw new ValidationException("Mobile number is invalid.Please check your mobile number entered");
	}

	public static void validateInterviewerName(String interviewerName) throws ValidationException {
		if (StringUtils.isEmpty(interviewerName))
			throw new ValidationException("Interviewer name can't be null");
		if (interviewerName.length() < 5 || interviewerName.length() > 30)
			throw new ValidationException(
					"Interviewer name length is invalid. Please make sure the length is between 5 and 30");
	}

	public static void validateIntervieName(String interviewName) throws ValidationException {
		if (StringUtils.isEmpty(interviewName))
			throw new ValidationException("Interview name can't be null");
		if (interviewName.length() < 3 || interviewName.length() > 30)
			throw new ValidationException(
					"Interview name length is invalid. Please make sure the length is between 5 and 30");
	}

	public static void validateUserSkills(String userskills) throws ValidationException {
		if (StringUtils.isEmpty(userskills))
			throw new ValidationException("User skills can't be null");
		if (userskills.length() < 5 || userskills.length() > 30)
			throw new ValidationException(
					"User skills length is invalid. Please make sure the length is between 5 and 30");
	}

	public static void validateInterviewStatus(String interviewStatus) throws ValidationException {
		if (StringUtils.isEmpty(interviewStatus))
			throw new ValidationException("Interview Status can't be null");
		if (interviewStatus.length() < 5 || interviewStatus.length() > 100)
			throw new ValidationException(
					"Interview Status length is invalid. Please make sure the length is between 5 and 30");
	}

	public static void validateRemarks(String remarks) throws ValidationException {
		if (StringUtils.isEmpty(remarks))
			throw new ValidationException("Remarks can't be null");
		if (remarks.length() < 5 || remarks.length() > 100)
			throw new ValidationException(
					"Remarks name length is invalid. Please make sure the length is between 5 and 30");
	}

}
