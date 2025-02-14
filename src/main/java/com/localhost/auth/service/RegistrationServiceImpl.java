package com.localhost.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.localhost.auth.dao.AuthDao;
import com.localhost.auth.dao.UserDao;
import com.localhost.auth.dto.Auth;
import com.localhost.auth.dto.User;
import com.localhost.auth.dto.request.RegistrationRequestDto;
import com.localhost.auth.mapper.AuthMapper;
import com.localhost.auth.mapper.UserMapper;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	private final UserDao userDao;
	private final AuthDao authDao;
	private final UserMapper userMapper;
	private final AuthMapper authMapper;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public RegistrationServiceImpl(UserDao userDao, 
			AuthDao authDao,
			UserMapper userMapper, 
			AuthMapper authMapper,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDao = userDao;
		this.userMapper = userMapper;
		this.authMapper = authMapper;
		this.authDao = authDao;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public User registerUser(RegistrationRequestDto registrationRequestDto) {
		return userDao.registerUser(userMapper.mapTo(registrationRequestDto));
	}

	@Override
	public Auth registerDevice(RegistrationRequestDto registrationRequestDto) {
		Auth auth = authMapper.mapTo(registrationRequestDto);
		auth.setPassword(bCryptPasswordEncoder.encode(registrationRequestDto.getPassword()));
		return authDao.registerUser(auth);
	}
	
	private boolean verifyPassword(String rawPassword, String encodedPassword) {
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
    }

}
