package com.ooredoo.rest.controller;

import com.ooredoo.exception.FranchiseAlreadyExistsException;
import com.ooredoo.rest.dto.ResponseDto;
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
public class GlobalExceptionHandlerController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = FranchiseAlreadyExistsException.class)
	public ResponseEntity<Object> franchiseAlreadyExistsException(WebRequest request, FranchiseAlreadyExistsException ex) {
		ResponseDto responseDto = new ResponseDto("error", ex.getLocalizedMessage());
		return handleExceptionInternal(ex, responseDto, null, HttpStatus.CONFLICT, request);
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
		ResponseDto responseDto = new ResponseDto("error", ex.getLocalizedMessage(), errorList);
		return handleExceptionInternal(ex, responseDto, null, HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> globeExceptionHandler(WebRequest request, Exception ex) {
		ResponseDto responseDto = new ResponseDto("error", ex.getLocalizedMessage());
		return handleExceptionInternal(ex, responseDto, null, HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
}
