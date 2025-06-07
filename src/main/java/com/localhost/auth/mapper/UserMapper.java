/**
 * 
 */
package com.localhost.auth.mapper;

import java.util.UUID;

import com.localhost.customer.Customer;
import com.localhost.customer.CustomerCreateRequest;
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

	User mapTo(Customer customer);
	
	@Mapping(target = "userId", expression = "java( com.localhost.auth.mapper.UserMapper.generateUUID())")
	User mapTo(RegistrationRequestDto registrationRequestDto);

	public static String generateUUID() {
		return UUID.randomUUID().toString();
	}

	CustomerCreateRequest mapToCustomerCreate(User user);
}
