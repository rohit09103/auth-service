package com.localhost.auth.dto.response;


import com.localhost.auth.dto.Auth;
import com.localhost.auth.dto.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistrationResponse {
	
	private Auth auth;
	private User user;
}
