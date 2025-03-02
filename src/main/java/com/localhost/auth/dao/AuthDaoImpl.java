package com.localhost.auth.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.localhost.auth.dto.Auth;
import com.localhost.auth.entity.AuthEntity;
import com.localhost.auth.entity.UserDeviceEntity;
import com.localhost.auth.enums.DeviceStatus;
import com.localhost.auth.mapper.AuthMapper;
import com.localhost.auth.repository.AuthRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
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
		authEntity.setUserDeviceEntity(List.of(deviceEntity));
		authRepository.save(authEntity);
		authRepository.findAllByUserName(auth.getUserName()).forEach(it -> {
			 log.info("Entity: [{}]", it);
		 });
		return auth;
	}

	@Override
	public Auth findAuthWithUserName(String userName) {
		List<AuthEntity> usersByUserName = authRepository.findAllByUserName(userName);
		verifyOnlyOneAuthEntity(userName, usersByUserName);
		return authMapper.mapTo(usersByUserName.get(0));
	}

	/**
	 * @param userName
	 * @param usersByUserName
	 */
	private void verifyOnlyOneAuthEntity(String userName, List<AuthEntity> usersByUserName) {
		if (usersByUserName.isEmpty()) {
			throw new RuntimeException("No user found with name [" + userName + "]");
		}
		
		if (usersByUserName.stream().count() != 1) {
			log.error("For username [{}] found userIds [{}]", userName, 
					usersByUserName.stream().map(AuthEntity::getUserId).collect(Collectors.joining(", ")));
			throw new RuntimeException("More than 1 user found with name [" + userName + "]");
		}
	}

	@Override
	public Auth findAuthWithDevice(String device) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Auth findAuthWithUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
