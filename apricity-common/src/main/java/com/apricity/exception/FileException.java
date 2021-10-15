package com.apricity.exception;


public class FileException extends RuntimeException {
	private static final long serialVersionUID = 3199336072993488942L;

	public FileException(String message) {
		super(message);
	}

	public FileException(Throwable t) {
		super(t);
	}
}
