package com.interviewtracker.mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.interviewtracker.dao.UserDetailsDAO;
import com.interviewtracker.model.UserDetails;

public class UserDetailsMapper {
	
	public static UserDetails mapUserDetails(UserDetailsDAO userDetailsdto) {

		UserDetails userDao = new UserDetails();
		userDao.setFirstName(userDetailsdto.getFirstName());
		userDao.setLastName(userDetailsdto.getLastName());
		userDao.setEmail(userDetailsdto.getEmail());
		userDao.setMobile(userDetailsdto.getMobile());
		userDao.setUserId(userDetailsdto.getUserId());
		
		return userDao;
	}

	public static List<UserDetailsDAO> mapUserDetailsDtoList(Iterable<UserDetails> iterable) {

		List<UserDetailsDAO> userDTOList = new ArrayList<UserDetailsDAO>();
		Iterator<UserDetails> it = iterable.iterator();
		while (it.hasNext()) {
			UserDetailsDAO userDto = new UserDetailsDAO();
			UserDetails user = it.next();
			userDto.setUserId(user.getUserId());
			userDto.setFirstName(user.getFirstName());
			userDto.setLastName(user.getLastName());
			userDto.setMobile(user.getMobile());
			userDto.setEmail(user.getEmail());
			userDTOList.add(userDto);

		}
		return userDTOList;
	}

}
