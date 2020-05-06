package com.ooredoo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class FranchiseAlreadyExistsException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	public FranchiseAlreadyExistsException(String message) {
		super(message);
	}

}
