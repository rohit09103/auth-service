package com.localhost.auth.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Registration {

	private String userName;
	private String password;
	private String accessToken;
	private String refreshToken;
}
