package com.favmovies.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSave {
	private String userEmail;
	private String message;
	private Long code;
}
