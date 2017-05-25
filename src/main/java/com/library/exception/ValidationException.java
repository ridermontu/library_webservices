package com.library.exception;

public class ValidationException extends RuntimeException {
	public ValidationException() {
		super("Object Not Valid");
	}

}
