package com.localhost.auth.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.localhost.auth.dto.Auth;
import com.localhost.auth.entity.AuthEntity;
import com.localhost.auth.entity.UserDeviceEntity;
import com.localhost.auth.enums.DeviceStatus;
import com.localhost.auth.mapper.AuthMapper;
import com.localhost.auth.repository.AuthRepository;

@Component
public class AuthDaoImpl implements AuthDao {
	
	private final AuthRepository authRepository;
	private final AuthMapper authMapper;
	
	
	@Autowired
	public AuthDaoImpl(AuthRepository authRepository,
			AuthMapper authMapper) {
		this.authRepository = authRepository;
		this.authMapper = authMapper;
	}

	@Override
	public Auth registerUser(Auth auth) {
		AuthEntity authEntity = authMapper.mapTo(auth);
		UserDeviceEntity deviceEntity = new UserDeviceEntity();
		deviceEntity.setDeviceId(auth.getDeviceId());
		deviceEntity.setUserName(auth.getUserName());
		deviceEntity.setDeviceStatus(DeviceStatus.PENDING);
		authRepository.save(authEntity);
		return auth;
	}

	@Override
	public Auth findAuthWithUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Auth findAuthWithDevice(String device) {
		// TODO Auto-generated method stub
		return null;
	}

}
