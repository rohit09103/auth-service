package com.localhost.auth.dto.response;


import com.localhost.auth.dto.Auth;
import com.localhost.auth.dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationResponseDto {
	
	private Auth auth;
	private User user;
}
