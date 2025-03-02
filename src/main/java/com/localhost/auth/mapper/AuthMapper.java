/**
 * 
 */
package com.localhost.auth.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.localhost.auth.dto.Auth;
import com.localhost.auth.dto.request.RegistrationRequestDto;
import com.localhost.auth.entity.AuthEntity;

/**
 * 
 */
@Mapper(componentModel = "spring")
public interface AuthMapper {
	
	@Mapping(ignore = true, target = "accessToken")
	@Mapping(ignore = true, target = "refreshToken")
	@Mapping(ignore = true, target = "deviceId")
	Auth mapTo(AuthEntity entity);
	
	@Mapping(ignore = true, target = "id")
	@Mapping(ignore = true, target = "userDeviceEntity")
	AuthEntity mapTo(Auth auth);
	
	@Mapping(ignore = true, target = "accessToken")
	@Mapping(ignore = true, target = "refreshToken")
	@Mapping(ignore = true, target = "password")
	Auth mapTo(RegistrationRequestDto registrationRequestDto, String userId);

}
