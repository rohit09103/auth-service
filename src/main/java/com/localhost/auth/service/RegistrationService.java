/**
 * 
 */
package com.localhost.auth.service;

import com.localhost.auth.dto.Auth;
import com.localhost.auth.dto.User;
import com.localhost.auth.dto.request.RegistrationRequestDto;

/**
 * User and Device Registration service
 */
public interface RegistrationService {
	/**
	 * To register user in system.
	 * @param registrationRequestDto
	 * @return
	 */
	public User registerUser(RegistrationRequestDto registrationRequestDto);
	
	/**
	 * To register auth and device into system.
	 * @param registrationRequestDto
	 * @return
	 */
	public Auth registerDevice(RegistrationRequestDto registrationRequestDto, String userId);
}
