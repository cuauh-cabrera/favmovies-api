package com.favmovies.api.mapper.impl;

import org.springframework.stereotype.Component;

import com.favmovies.api.entity.User;
import com.favmovies.api.mapper.IMapper;
import com.favmovies.api.model.UserDTO;

@Component
public class UserInToUserDTO implements IMapper<User, UserDTO> {

	@Override
	public UserDTO map(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(user.getUserId());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		userDTO.setUserEmail(user.getUserEmail());
		return userDTO;
	}

}
