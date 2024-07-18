package com.appsdeveloper.orderapp.users.exceptions;

public class UserNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8746182825111706308L;

	public UserNotFoundException(String message) {
        super(message);
    }
}