package com.veris.crud.exceptions.custom;

public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 6366834812732498285L;

	public NotFoundException(String message) {
		super(message);
	}
}
