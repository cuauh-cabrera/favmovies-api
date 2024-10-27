package com.favmovies.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.favmovies.api.constants.UserConstants;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoContentException extends RuntimeException {
	private String message = UserConstants.NO_CONTENT_MSG;
	private String Error;

	public NoContentException() {

	}

	public NoContentException(String Error) {
		super(Error, null, true, false);
	}
}
