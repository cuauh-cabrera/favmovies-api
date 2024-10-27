package com.favmovies.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.favmovies.api.constants.UserConstants;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerErrorException extends RuntimeException {
	private String message = UserConstants.SERVER_ERROR_MSG;
	private String Error;

	public ServerErrorException() {

	}

	public ServerErrorException(String Error) {
		super(Error, null, true, false);
	}

}
