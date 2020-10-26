package com.interviewtracker.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interviewtracker.dao.InterviewDetailsDAO;
import com.interviewtracker.exception.ValidationException;
import com.interviewtracker.mapper.InterviewDetailsMapper;
import com.interviewtracker.model.InterviewDetails;
import com.interviewtracker.repository.IInterviewDetailsRepository;

@Service
public class InterviewServiceImpl implements IInterviewService {

	@Autowired
	private IInterviewDetailsRepository interviewRepository;

	@Override
	public void saveInterview(InterviewDetailsDAO interviewDetailsdto) {

		interviewRepository.save(InterviewDetailsMapper.mapInterviewDetails(interviewDetailsdto));
	}

	@Override
	public void deleteInterview(int id) throws ValidationException {

		Optional<InterviewDetails> interview = interviewRepository.findById(id);
		if (interview.isPresent())
			interviewRepository.deleteById(id);
		else
			throw new ValidationException("Interview with given id: " + id + " doesn't exist");
	}

	@Override
	public String updateInterviewStatus(int id, String interviewStatus) {

		InterviewDetails interviewDetails = interviewRepository.findById(id).orElse(null);
		if (interviewDetails != null) {
			interviewDetails.setInterviewStatus(interviewStatus);
			interviewRepository.save(interviewDetails);
			return "Interview status updated to: " + interviewStatus + " for given interviewid: " + id;
		} else
			return null;
	}

	@OneToMany(mappedBy = "interviewId")
	@Override
	public List<InterviewDetailsDAO> returnInterviewList() {
		return InterviewDetailsMapper.mapInterviewDetailsDtoList(interviewRepository.findAll());

	}

	@Override
	public long returnInterviewCount() {
		return interviewRepository.count();
	}

	@Override
	public InterviewDetails returnInterviewDetails(String interviewName, String interviewerName) {

		return interviewRepository.findByInterviewNameAndInterviewerName(interviewName, interviewerName);
	}

}
