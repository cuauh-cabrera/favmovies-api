package com.favmovies.api.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUser {
	private String message;
	private Long code;
	private List<UserDTO> users;
}
