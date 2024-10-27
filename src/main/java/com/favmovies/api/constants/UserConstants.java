package com.favmovies.api.constants;

public class UserConstants {
	public static final Boolean FILTER = false;
	public static final String REQUIRED_NAME = "The Name field is required";
	public static final String REQUIRED_LAST_NAME = "The last name field is required";
	public static final String REQUIRED_EMAIL = "The Email field is required";
	public static final String INVALID_EMAIL = "Invalid Email format, please enter a valid Email";
	public static final String SUCCESS_MESSAGE = "Success";
	public static final String SUCCESS_LOG = "Successful Request";
	public static final String CREATED_MSG = "User created successfully";
	public static final String UPDATED_MSG = "User updated successfully";
	public static final String DELETED_MSG = "User deleted successfully";
	public static final String SERVER_ERROR_LOG = "Error: Please check the connection to the database and correct implementation of the Repository layer";
	public static final String SERVER_ERROR_MSG = "Unable to process the request at this time, please try again later";
	public static final String NO_CONTENT_LOG = "No content";
	public static final String NO_CONTENT_MSG = "The Request did not return any results.";
	public static final String NOT_FOUND_LOG = "Not Found";
	public static final String NOT_FOUND_MSG = "The requested User could not be found";
	public static final String USER_EXISTS_MSG = "The Email address already exists";
	public static final String USER_EXISTS_LOG = "Duplicated Email";

	private UserConstants() {
	}

}
