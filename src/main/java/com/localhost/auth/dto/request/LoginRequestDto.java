package com.localhost.auth.dto.request;


import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginRequestDto implements Serializable{
	
	private static final long serialVersionUID = 4384354144728170928L;
	@NotEmpty(message = "User Name can not be empty.")
	@Size(message = "User Name should be atleast 8 character long.", min = 8)
	private String userName;
	@NotEmpty(message = "Password can not be empty.")
	@Size(message = "Password should be atleast 12 character long.", min = 12)
	private String password;
	@NotEmpty(message = "Device can not be empty.")
	@Size(message = "DeviceId should be between 36-72 character long.", min = 36, max = 72)
	private String deviceId; //Ignore for now, later use this to verify device and allow t login or not.

}
