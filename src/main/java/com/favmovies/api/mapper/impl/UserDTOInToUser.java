package com.favmovies.api.mapper.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.favmovies.api.entity.User;
import com.favmovies.api.mapper.IMapper;
import com.favmovies.api.model.UserDTO;

@Component
public class UserDTOInToUser implements IMapper<UserDTO, User> {

	@Override
	public User map(UserDTO userDTO) {
		User user = new User();
		if (userDTO.getUserId()!=null) {
			user.setUserId(userDTO.getUserId());
		}
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setUserEmail(userDTO.getUserEmail());
		user.setCreatedAt(LocalDate.now());
		user.setModifiedAt(LocalDate.now());
		user.setIsActive(true);
		return user;
	}

}
