package com.favmovies.api.service;

import com.favmovies.api.model.ResponseSave;
import com.favmovies.api.model.ResponseUser;
import com.favmovies.api.model.UserDTO;

public interface IUserService {
	
	public ResponseUser readAll();
	
	public ResponseUser readById(Long userId);
	
	public ResponseSave insert(String userEmail,UserDTO user);
	
	public ResponseSave update(Long userId, UserDTO userDTO);
	
	public ResponseSave deleteById(Long userId);

}
