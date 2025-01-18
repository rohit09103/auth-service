package com.localhost.auth.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
}
