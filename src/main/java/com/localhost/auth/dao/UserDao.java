/**
 * 
 */
package com.localhost.auth.dao;

import java.util.List;

import com.localhost.auth.dto.User;

/**
 * 
 */
public interface UserDao {
	
	public User registerUser(User user);
	public List<User> findAllUserWithName(String firstName, String lastName);
	public List<User> findAllUserWithPhoneNumber(String phoneNumber);
	public List<User> findAllUserWithEmail(String email);
	public List<User> findAllUserWithUserId(String userId);
	public User findUserWithUserId(String userId);

}
