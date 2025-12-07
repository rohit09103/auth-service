/**
 * 
 */
package com.localhost.auth.exception;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.localhost.auth.dto.response.BaseErrorResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * To handle exceptions.
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<List<BaseErrorResponse>> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
		log.error("Exception occured while proccessing incoming request, invalid requst with [{}]", methodArgumentNotValidException.getAllErrors());
		return ResponseEntity.badRequest().body(methodArgumentNotValidException.getAllErrors().stream()
				.map(it -> new BaseErrorResponse(it.getCode(), it.getDefaultMessage()))
				.toList());
		
		
	}

}
