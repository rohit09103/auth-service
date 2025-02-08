/**
 * 
 */
package com.localhost.auth.mapper;

import org.mapstruct.Mapper;

import com.localhost.auth.dto.Auth;
import com.localhost.auth.dto.request.RegistrationRequestDto;
import com.localhost.auth.entity.AuthEntity;

/**
 * 
 */
@Mapper(componentModel = "spring")
public interface AuthMapper {
	
	Auth mapTo(AuthEntity entity);
	
	AuthEntity mapTo(Auth auth);
	
	Auth mapTo(RegistrationRequestDto registrationRequestDto);

}
