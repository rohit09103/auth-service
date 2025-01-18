/**
 * 
 */
package com.localhost.dao;

import java.util.List;

import com.localhost.auth.dto.User;

/**
 * 
 */
public interface UserDao {
	
	public User registerUser(User user);
	public List<User> findUserWithName(String firstName, String lastName);
	public User findUserWithPhoneNumber(String phoneNumber);
	public User findUserWithEmail(String email);

}
