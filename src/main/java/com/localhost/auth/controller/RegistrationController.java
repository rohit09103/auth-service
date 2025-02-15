package com.localhost.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.localhost.auth.dto.Auth;
import com.localhost.auth.dto.User;
import com.localhost.auth.dto.request.RegistrationRequestDto;
import com.localhost.auth.dto.response.RegistrationResponse;
import com.localhost.auth.service.RegistrationService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(methods = { RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.HEAD,
		RequestMethod.DELETE, RequestMethod.PATCH,
		RequestMethod.PUT }, origins = { "http://127.0.0.1:5500" }, allowedHeaders = "*")
@Slf4j
public class RegistrationController {

	private final RegistrationService registrationService;

	@Autowired
	public RegistrationController(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}

	@PostMapping("/register")
	public RegistrationResponse registerCustomer(@RequestBody @Valid RegistrationRequestDto registrationRequestDto) {
		log.info("Recieved request to register. [{}]", registrationRequestDto);

		log.info("Starting user registration.");
		User user = registrationService.registerUser(registrationRequestDto);
		log.info("Completed user registration.");

		log.info("Starting device registration.");
		Auth auth = registrationService.registerDevice(registrationRequestDto);
		log.info("Completed device registration.");

		return new RegistrationResponse(auth, user);
	}
}
