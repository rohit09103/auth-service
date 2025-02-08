/**
 * 
 */
package com.localhost.dao;

import com.localhost.auth.dto.Auth;

/**
 * 
 */
public interface AuthDao {
	
	public Auth registerUser(Auth auth);
	public Auth findAuthWithUserName(String userName);
	public Auth findAuthWithDevice(String device);

}
