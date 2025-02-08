package com.localhost.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.localhost.auth.dto.Auth;
import com.localhost.auth.dto.User;
import com.localhost.auth.dto.request.RegistrationRequestDto;
import com.localhost.auth.mapper.AuthMapper;
import com.localhost.auth.mapper.UserMapper;
import com.localhost.dao.AuthDao;
import com.localhost.dao.UserDao;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	private final UserDao userDao;
	private final AuthDao authDao;
	private final UserMapper userMapper;
	private final AuthMapper authMapper;
	
	@Autowired
	public RegistrationServiceImpl(UserDao userDao, 
			AuthDao authDao,
			UserMapper userMapper, 
			AuthMapper authMapper) {
		this.userDao = userDao;
		this.userMapper = userMapper;
		this.authMapper = authMapper;
		this.authDao = authDao;
	}

	@Override
	public User registerUser(RegistrationRequestDto registrationRequestDto) {
		return userDao.registerUser(userMapper.mapTo(registrationRequestDto));
	}

	@Override
	public Auth registerDevice(RegistrationRequestDto registrationRequestDto) {
		return authDao.registerUser(authMapper.mapTo(registrationRequestDto));
	}

}
