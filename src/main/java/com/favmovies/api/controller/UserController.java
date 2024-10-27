package com.favmovies.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.favmovies.api.model.ResponseSave;
import com.favmovies.api.model.ResponseUser;
import com.favmovies.api.model.UserDTO;
import com.favmovies.api.service.IUserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

	private final IUserService userService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/users")
	public ResponseUser readAll() {
		return userService.readAll();
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/users/{userId}")
	public ResponseUser readById(@PathVariable Long userId) {
		return userService.readById(userId);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/users")
	public ResponseSave insert(@RequestParam String userEmail, @RequestBody @Valid UserDTO userDTO) {
		return userService.insert(userEmail, userDTO);
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/users/{userId}")
	public ResponseSave update(@PathVariable Long userId, @RequestBody @Valid UserDTO userDTO) {
		userDTO.setUserId(userId);
		return userService.update(userId, userDTO);
	}

	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/users/{userId}")
	public ResponseSave deleteById(@PathVariable Long userId) {
		return userService.deleteById(userId);
	}
}


