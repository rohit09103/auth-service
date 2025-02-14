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
import com.localhost.auth.util.JwtUtil;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	private final UserDao userDao;
	private final AuthDao authDao;
	private final UserMapper userMapper;
	private final AuthMapper authMapper;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final JwtUtil jwtUtil;
	
	@Autowired
	public RegistrationServiceImpl(UserDao userDao, 
			AuthDao authDao,
			UserMapper userMapper, 
			AuthMapper authMapper,
			BCryptPasswordEncoder bCryptPasswordEncoder,
			JwtUtil jwtUtil) {
		this.userDao = userDao;
		this.userMapper = userMapper;
		this.authMapper = authMapper;
		this.authDao = authDao;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.jwtUtil = jwtUtil;
	}

	@Override
	public User registerUser(RegistrationRequestDto registrationRequestDto) {
		return userDao.registerUser(userMapper.mapTo(registrationRequestDto));
	}

	@Override
	public Auth registerDevice(RegistrationRequestDto registrationRequestDto) {
		Auth auth = authMapper.mapTo(registrationRequestDto);
		auth.setPassword(bCryptPasswordEncoder.encode(registrationRequestDto.getPassword()));
		authDao.registerUser(auth);
		auth.setAccessToken(jwtUtil.generateAccessToken(auth.getUserName()));
		auth.setRefreshToken(jwtUtil.generateRefreshToken(auth.getUserName()));
		return authDao.registerUser(auth);
	}
	
	private boolean verifyPassword(String rawPassword, String encodedPassword) {
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
    }

}
