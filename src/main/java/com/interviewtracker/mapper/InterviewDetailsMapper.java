package com.interviewtracker.mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.interviewtracker.dao.InterviewDetailsDAO;
import com.interviewtracker.model.InterviewDetails;

public class InterviewDetailsMapper {

	public static InterviewDetails mapInterviewDetails(InterviewDetailsDAO interviewDetailsdto) {

		InterviewDetails interviewDao = new InterviewDetails();
		interviewDao.setInterviewId(interviewDetailsdto.getInterviewId());
		interviewDao.setDate(interviewDetailsdto.getDate());
		interviewDao.setTime(interviewDetailsdto.getTime());
		interviewDao.setInterviewerName(interviewDetailsdto.getInterviewerName());
		interviewDao.setInterviewName(interviewDetailsdto.getInterviewName());
		interviewDao.setInterviewStatus(interviewDetailsdto.getInterviewStatus());
		interviewDao.setRemarks(interviewDetailsdto.getRemarks());
		interviewDao.setUsersSkills(interviewDetailsdto.getUsersSkills());
		return interviewDao;
	}

	public static List<InterviewDetailsDAO> mapInterviewDetailsDtoList(Iterable<InterviewDetails> iterable) {

		List<InterviewDetailsDAO> interviewDTOList = new ArrayList<InterviewDetailsDAO>();
		Iterator<InterviewDetails> it = iterable.iterator();
		while (it.hasNext()) {
			InterviewDetailsDAO interviewDto = new InterviewDetailsDAO();
			InterviewDetails interview = it.next();
			interviewDto.setInterviewId(interview.getInterviewId());
			interviewDto.setDate(interview.getDate());
			interviewDto.setTime(interview.getTime());
			interviewDto.setInterviewerName(interview.getInterviewerName());
			interviewDto.setInterviewName(interview.getInterviewName());
			interviewDto.setInterviewStatus(interview.getInterviewStatus());
			interviewDto.setRemarks(interview.getRemarks());
			interviewDto.setUsersSkills(interview.getUsersSkills());
			interviewDTOList.add(interviewDto);
		}
		return interviewDTOList;
	}
}
