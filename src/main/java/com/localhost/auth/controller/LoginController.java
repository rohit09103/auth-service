package com.localhost.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.localhost.auth.dto.request.LoginRequestDto;
import com.localhost.auth.dto.response.LoginResponseDto;
import com.localhost.auth.service.LoginService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(methods = { RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.HEAD,
		RequestMethod.DELETE, RequestMethod.PATCH,
		RequestMethod.PUT }, origins = { "http://127.0.0.1:5500" }, allowedHeaders = "*")
@Slf4j
public class LoginController implements AuthController{

	private final LoginService loginService;

	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@PostMapping("/login")
	public LoginResponseDto loginCustomer(@RequestBody @Valid LoginRequestDto loginRequestDto) {
		log.info("Recieved request to login. [{}]", loginRequestDto);
		return loginService.login(loginRequestDto);
	}
}
