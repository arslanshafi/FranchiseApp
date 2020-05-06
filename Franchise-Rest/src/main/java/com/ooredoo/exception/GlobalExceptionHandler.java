package com.ooredoo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = FranchiseAlreadyExistsException.class)
	public ResponseEntity<Object> franchiseAlreadyExistsException(FranchiseAlreadyExistsException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex.getMessage());
		return handleExceptionInternal(ex, errorDetails, null, errorDetails.getStatus(), request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
																  HttpHeaders headers, HttpStatus status,
																  WebRequest request) {
		List<String> errorList = ex
				.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(fieldError -> fieldError.getDefaultMessage())
				.collect(Collectors.toList());
		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errorList);
		return handleExceptionInternal(ex, errorDetails, headers, errorDetails.getStatus(), request);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> globeExceptionHandler(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), ex.getMessage());
		return handleExceptionInternal(ex, errorDetails, null, errorDetails.getStatus(), request);
	}
}
