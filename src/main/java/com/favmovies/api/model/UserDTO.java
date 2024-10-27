package com.favmovies.api.model;

import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private Long userId;

	@NotNull
	@Length(min = 1, max = 255)
	private String firstName;

	@NotNull
	@Length(min = 1, max = 255)
	private String lastName;

	@NotNull
	@Email
	private String userEmail;
}
