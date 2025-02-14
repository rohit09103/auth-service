package com.localhost.auth.dto.request;


import java.io.Serializable;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistrationRequestDto implements Serializable{
	
	private static final long serialVersionUID = -1816868912996827824L;
	@NotEmpty(message = "First Name can not be empty.")
	@Size(message = "First Name should be atleast 2 character long.", min = 2)
	private String firstName;
	@NotEmpty(message = "Last Name can not be empty.")
	@Size(message = "Last Name should be atleast 2 character long.", min = 2)
	private String lastName;
	@NotEmpty(message = "Phone number can not be empty.")
	@Size(message = "Phone number should be 10 digits.", min = 10, max = 10)
	@Digits(fraction = 0, integer = 10)
	private String phoneNumber;
	@Email
	private String email;
	@NotEmpty(message = "User Name can not be empty.")
	@Size(message = "User Name should be atleast 8 character long.", min = 8)
	private String userName;
	@NotEmpty(message = "Password can not be empty.")
	@Size(message = "Password should be atleast 12 character long.", min = 12)
	private String password;
	@NotEmpty(message = "Device can not be empty.")
	@Size(message = "DeviceId should be between 36-72 character long.", min = 36, max = 72)
	private String deviceId;

}
