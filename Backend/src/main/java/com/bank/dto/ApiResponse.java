package com.bank.dto;

import java.time.LocalDateTime;

import lombok.Getter;
@Getter
public class ApiResponse {
	private String message;
	private LocalDateTime timeStamp;
	public ApiResponse(String message) {
		super();
		this.message = message;
		timeStamp=LocalDateTime.now();
	}
	

}
