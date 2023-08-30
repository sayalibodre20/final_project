package com.bank.exception;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;



public class GlobalException {
	//can contain single /multiple exc handling methods
		//how to tell sc,following method:exc handling method
		@SuppressWarnings("unused")
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<?> handlermethodArgumentnotValidException(MethodArgumentNotValidException e)
		{
		
			Map<String , String> map=e.getFieldErrors().stream().collect(Collectors.toMap(f-> f.getField(),f->f.getDefaultMessage())); 
		
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getFieldError());
		}
		
		//add another exc handling method to handle resource not found exception 
		@ExceptionHandler(ResourceNotFoundException.class)
		public ResponseEntity<?> resourceNotFoundException(MethodArgumentNotValidException e)
		{
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
}
