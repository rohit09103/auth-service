package com.localhost.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.localhost.auth.dto.User;
import com.localhost.auth.mapper.UserMapper;
import com.localhost.auth.repository.UserRepository;

@Component
public class UserDaoImpl implements UserDao {
	
	private final UserRepository userRepository;
	private final UserMapper userMapper;

	@Autowired
	public UserDaoImpl(UserRepository userRepository, 
			UserMapper userMapper) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	@Override
	public User registerUser(User user) {
		userRepository.save(userMapper.mapTo(user));
		return user;
	}

	@Override
	public List<User> findUserWithName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserWithPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserWithEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
