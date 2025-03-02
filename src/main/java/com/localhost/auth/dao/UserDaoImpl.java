package com.localhost.auth.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.localhost.auth.dto.User;
import com.localhost.auth.entity.UserEntity;
import com.localhost.auth.mapper.UserMapper;
import com.localhost.auth.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
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
	public List<User> findAllUserWithName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUserWithPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUserWithEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUserWithUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserWithUserId(String userId) {
		List<UserEntity> usersByUserId = userRepository.findAllByUserId(userId);
		verifyOnlyOneUserEntity(userId, usersByUserId);
		return userMapper.mapTo(usersByUserId.get(0));
	}
	
	/**
	 * @param userId
	 * @param usersByUserId
	 */
	private void verifyOnlyOneUserEntity(String userId, List<UserEntity> usersByUserId) {
		if (usersByUserId.isEmpty()) {
			throw new RuntimeException("No user found with id [" + userId + "]");
		}
		
		if (usersByUserId.stream().count() != 1) {
			log.error("For username [{}] found userIds [{}]", userId, 
					usersByUserId.stream().map(UserEntity::getEmail).collect(Collectors.joining(", ")));
			throw new RuntimeException("More than 1 user found with id [" + userId + "]");
		}
	}

}
