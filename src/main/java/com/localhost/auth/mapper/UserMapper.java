/**
 * 
 */
package com.localhost.auth.mapper;

import org.mapstruct.Mapper;

import com.localhost.auth.dto.User;
import com.localhost.auth.dto.request.RegistrationRequestDto;
import com.localhost.auth.entity.UserEntity;

/**
 * 
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
	
	User mapTo(UserEntity entity);
	UserEntity mapTo(User user);
	User mapTo(RegistrationRequestDto registrationRequestDto);

}
