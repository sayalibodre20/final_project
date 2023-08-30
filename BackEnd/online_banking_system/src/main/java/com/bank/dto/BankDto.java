package com.bank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BankDto {
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	private String location;
	private int pinCode;
}
