package com.localhost.auth.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.localhost.auth.dto.request.RegistrationRequestDto;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RegistrationController {

	
	@PostMapping("/register")
	public RegistrationRequestDto registerCustomer(@RequestBody @Valid RegistrationRequestDto registrationRequestDto) {
		log.info("Recieved request to register. [{}]", registrationRequestDto);
		return registrationRequestDto;
	}
}
