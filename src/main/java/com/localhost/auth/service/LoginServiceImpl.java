package com.localhost.auth.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.localhost.auth.dao.AuthDao;
import com.localhost.auth.dao.UserDao;
import com.localhost.auth.dto.Auth;
import com.localhost.auth.dto.User;
import com.localhost.auth.dto.request.LoginRequestDto;
import com.localhost.auth.dto.response.LoginResponseDto;
import com.localhost.auth.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
	
	private final UserDao userDao;
	private final AuthDao authDao;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final JwtUtil jwtUtil;
	
	@Autowired
	public LoginServiceImpl(UserDao userDao, 
			AuthDao authDao,
			BCryptPasswordEncoder bCryptPasswordEncoder,
			JwtUtil jwtUtil) {
		this.userDao = userDao;
		this.authDao = authDao;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.jwtUtil = jwtUtil;
	}
	
	@Override
	public LoginResponseDto login(LoginRequestDto loginRequestDto) {
		Auth auth = authDao.findAuthWithUserName(loginRequestDto.getUserName());
		//ignore deviceId mismatch
		if (!verifyPassword(loginRequestDto.getPassword(), auth.getPassword())) {
			log.error("Incorrect login credentials.");
			throw new RuntimeException("Bad Login.");
		}
		
		User user = userDao.findUserWithUserId(auth.getUserId());
		
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("userId", auth.getUserId());
		claims.put("deviceId", auth.getDeviceId());
		auth.setAccessToken(jwtUtil.generateAccessToken(auth.getUserName(), claims));
		auth.setRefreshToken(jwtUtil.generateRefreshToken(auth.getUserName(), claims));
		
		return new LoginResponseDto(auth, user);
	}
	
	private boolean verifyPassword(String rawPassword, String encodedPassword) {
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
    }


}
