/**
 * 
 */
package com.localhost.auth.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.localhost.auth.dto.User;
import com.localhost.auth.dto.request.RegistrationRequestDto;
import com.localhost.auth.entity.UserEntity;

/**
 * 
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
	
	User mapTo(UserEntity entity);
	@Mapping(ignore = true, target = "id")
	UserEntity mapTo(User user);
	User mapTo(RegistrationRequestDto registrationRequestDto);

}
