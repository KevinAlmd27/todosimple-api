package com.dev.kevin.service.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DataBindingViolationException extends DataIntegrityViolationException {

	public DataBindingViolationException(String message) {
		super(message);
	}
}
