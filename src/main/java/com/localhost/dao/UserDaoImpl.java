package com.localhost.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.localhost.auth.dto.User;
import com.localhost.auth.entity.UserEntity;
import com.localhost.auth.repository.UserRepository;

@Component
public class UserDaoImpl implements UserDao {
	
	private UserRepository userRepository;

	@Autowired
	public UserDaoImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User registerUser(User user) {
		UserEntity userEntity = new UserEntity();
		userEntity.setEmail(user.getEmail());
		userEntity.setPhoneNumber(user.getPhoneNumber());
		userEntity.setFirstName(user.getFirstName());
		userEntity.setLastName(user.getLastName());
		userRepository.save(userEntity);
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
