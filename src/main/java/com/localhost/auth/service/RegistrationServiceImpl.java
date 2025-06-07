package com.localhost.auth.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	public RegistrationServiceImpl(@Qualifier("userGrpcDaoImpl") UserDao userDao,
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
	public Auth registerDevice(RegistrationRequestDto registrationRequestDto, String userId) {
		Auth auth = authMapper.mapTo(registrationRequestDto, userId);
		auth.setPassword(bCryptPasswordEncoder.encode(registrationRequestDto.getPassword()));
		auth = authDao.registerUser(auth);
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("userId", auth.getUserId());
		claims.put("deviceId", auth.getDeviceId());
		auth.setAccessToken(jwtUtil.generateAccessToken(auth.getUserName(), claims));
		auth.setRefreshToken(jwtUtil.generateRefreshToken(auth.getUserName(), claims));
		return auth;
	}
	
}
