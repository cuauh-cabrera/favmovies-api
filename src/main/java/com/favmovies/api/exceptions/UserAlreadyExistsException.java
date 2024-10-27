package com.favmovies.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.favmovies.api.constants.UserConstants;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserAlreadyExistsException extends RuntimeException {
	private String message = UserConstants.USER_EXISTS_MSG;
	private String Error;

	public UserAlreadyExistsException() {

	}

	public UserAlreadyExistsException(String Error) {
		super(Error, null, true, false);
	}

}
