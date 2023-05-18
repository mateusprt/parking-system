package com.parking.exceptions.handlers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.parking.exceptions.EnumTypeNotFoundException;
import com.parking.exceptions.ExceptionResponse;
import com.parking.exceptions.ResourceNotFoundException;

import jakarta.validation.ConstraintViolationException;



@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> handleAllExecptions(Exception e, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), List.of("INTERNAL SERVER ERROR"), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<ExceptionResponse> handlePasswordDoesntMatchExecptions(BadCredentialsException e, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), List.of(e.getMessage()), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleResourceNotFoundExecptions(ResourceNotFoundException e, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), List.of(e.getMessage()), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValid (MethodArgumentNotValidException e, WebRequest request) {
		List<String> listOfErrorsMessages = new ArrayList<>();
		e.getBindingResult().getAllErrors().forEach((error) -> {
	        String errorMessage = error.getDefaultMessage();
	        listOfErrorsMessages.add(errorMessage);
		});
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), listOfErrorsMessages, request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ExceptionResponse> handleResourceNotFoundExecptions(AccessDeniedException e, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), List.of(e.getMessage()), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ExceptionResponse> handleHttpMessageNotReadableExceptions(HttpMessageNotReadableException e, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), List.of("Request format incorrect"), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ExceptionResponse> handleConstraintViolationExceptions(ConstraintViolationException e, WebRequest request) {
		List<String> errors = new ArrayList<>();
        e.getConstraintViolations().forEach(violation -> {
            errors.add(violation.getMessage());
        });
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), errors, request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EnumTypeNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleEnumTypeNotFoundExceptions(EnumTypeNotFoundException e, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), List.of(e.getMessage()), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
