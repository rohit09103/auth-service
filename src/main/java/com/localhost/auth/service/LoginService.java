/**
 * 
 */
package com.localhost.auth.service;

import com.localhost.auth.dto.request.LoginRequestDto;
import com.localhost.auth.dto.response.LoginResponseDto;

/**
 * User login
 */
public interface LoginService {
	/**
	 * To login a user
	 * @param loginRequestDto
	 * @return
	 */
	public LoginResponseDto login(LoginRequestDto loginRequestDto);
	
}
