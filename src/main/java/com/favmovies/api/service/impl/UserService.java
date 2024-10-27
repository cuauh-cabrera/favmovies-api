package com.favmovies.api.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.favmovies.api.constants.UserConstants;
import com.favmovies.api.entity.User;
import com.favmovies.api.exceptions.NoContentException;
import com.favmovies.api.exceptions.NotFoundException;
import com.favmovies.api.exceptions.ServerErrorException;
import com.favmovies.api.exceptions.UserAlreadyExistsException;
import com.favmovies.api.mapper.impl.UserDTOInToUser;
import com.favmovies.api.mapper.impl.UserInToUserDTO;
import com.favmovies.api.model.ResponseSave;
import com.favmovies.api.model.ResponseUser;
import com.favmovies.api.model.UserDTO;
import com.favmovies.api.repository.UserRepository;
import com.favmovies.api.service.IUserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements IUserService {
	
	private final UserRepository userRepository;
	private final UserInToUserDTO mapperRead;
	private final UserDTOInToUser mapperSave;

	@Override
	public ResponseUser readAll() {
		try {
			List<User> userList = userRepository.findAll().stream()
					.filter(user -> user.getIsActive() != UserConstants.FILTER && user.getIsActive() != null).toList();

			if (userList.isEmpty()) {
				log.error(UserConstants.NO_CONTENT_LOG);
				throw new NoContentException(UserConstants.NO_CONTENT_MSG);
			} else {
				List<UserDTO> userDTOs = userList.stream().map(user -> {
					return mapperRead.map(user);
				}).toList();

				ResponseUser responseUser = new ResponseUser();
				responseUser.setMessage(UserConstants.SUCCESS_MESSAGE);
				responseUser.setCode(200L);
				responseUser.setUsers(userDTOs);
				log.info(UserConstants.SUCCESS_LOG);
				return responseUser;
			}

		} catch (ServerErrorException e) {
			log.error(UserConstants.SERVER_ERROR_LOG);
			throw new ServerErrorException(UserConstants.SERVER_ERROR_MSG);
		}
	}

	@Override
	public ResponseUser readById(Long userId) {
		try {
			Optional<User> userOptional = userRepository.findById(userId);

			if (userOptional.isEmpty() || userOptional.get().getIsActive() == UserConstants.FILTER || userOptional.get().getIsActive() == null) {
				log.error(UserConstants.NOT_FOUND_LOG);
				throw new NotFoundException(UserConstants.NOT_FOUND_MSG);
			} else {
				User user = userOptional.get();
				List<UserDTO> userDTOs = Stream.of(user).map(u -> {
					return mapperRead.map(user);
				}).toList();

				ResponseUser responseUser = new ResponseUser();
				responseUser.setMessage(UserConstants.SUCCESS_MESSAGE);
				responseUser.setCode(200L);
				responseUser.setUsers(userDTOs);
				log.info(UserConstants.SUCCESS_LOG);
				return responseUser;
			}

		} catch (ServerErrorException e) {
			log.error(UserConstants.SERVER_ERROR_LOG);
			throw new ServerErrorException(UserConstants.SERVER_ERROR_MSG);
		}
	}

	@Override
	public ResponseSave insert(String userEmail, UserDTO userDTO) {
		try {
			Optional<User> userOptional = userRepository.findByUserEmail(userEmail);

			if (userOptional.isPresent()) {
				log.error(UserConstants.USER_EXISTS_LOG);
				throw new UserAlreadyExistsException(UserConstants.USER_EXISTS_MSG);
			} else {
				User user = mapperSave.map(userDTO);
				userRepository.save(user);
				ResponseSave responseSave = new ResponseSave();
				responseSave.setUserEmail(user.getUserEmail());
				responseSave.setMessage(UserConstants.CREATED_MSG);
				responseSave.setCode(201L);
				log.info(UserConstants.SUCCESS_LOG);
				return responseSave;
			}

		} catch (ServerErrorException e) {
			log.error(UserConstants.SERVER_ERROR_LOG);
			throw new ServerErrorException(UserConstants.SERVER_ERROR_MSG);
		}
	}

	@Override
	public ResponseSave update(Long userId, UserDTO userDTO) {
		try {
			Optional<User> userOptional = userRepository.findById(userId);

			if (userOptional.isEmpty() || userOptional.get().getIsActive() == UserConstants.FILTER
					|| userOptional.get().getIsActive() == null) {
				log.error(UserConstants.NOT_FOUND_LOG);
				throw new NotFoundException(UserConstants.NOT_FOUND_MSG);
			} else {
				User user = mapperSave.map(userDTO);
				user = userRepository.save(user);
				ResponseSave responseSave = new ResponseSave();
				responseSave.setUserEmail(user.getUserEmail());
				responseSave.setMessage(UserConstants.UPDATED_MSG);
				responseSave.setCode(200L);
				return responseSave;
			}

		} catch (ServerErrorException e) {
			log.error(UserConstants.SERVER_ERROR_LOG);
			throw new ServerErrorException(UserConstants.SERVER_ERROR_MSG);
		}
	}

	@Override
	public ResponseSave deleteById(Long userId) {
		try {
			Optional<User> userOptional = userRepository.findById(userId);

			if (userOptional.isEmpty() || userOptional.get().getIsActive() == UserConstants.FILTER
					|| userOptional.get().getIsActive() == null) {
				log.error(UserConstants.NOT_FOUND_LOG);
				throw new NotFoundException(UserConstants.NOT_FOUND_MSG);
			} else {
				User user = userOptional.get();
				user.setIsActive(UserConstants.FILTER);
				userRepository.save(user);
				ResponseSave responseSave = new ResponseSave();
				responseSave.setUserEmail(user.getUserEmail());
				responseSave.setMessage(UserConstants.DELETED_MSG);
				responseSave.setCode(200L);
				return responseSave;
			}

		} catch (ServerErrorException e) {
			log.error(UserConstants.SERVER_ERROR_LOG);
			throw new ServerErrorException(UserConstants.SERVER_ERROR_MSG);
		}
	}

}
