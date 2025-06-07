package com.localhost.auth.dao;

import com.localhost.auth.dto.User;
import com.localhost.auth.entity.UserEntity;
import com.localhost.auth.mapper.UserMapper;
import com.localhost.auth.repository.UserRepository;
import com.localhost.customer.Customer;
import com.localhost.customer.CustomerClientServiceGrpc;
import com.localhost.customer.CustomerCreateReply;
import com.localhost.customer.CustomerFetchReply;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class UserGrpcDaoImpl implements UserDao {

	private final CustomerClientServiceGrpc.CustomerClientServiceBlockingStub customerClientServiceBlockingStub;
	private final UserMapper userMapper;

	@Autowired
	public UserGrpcDaoImpl(CustomerClientServiceGrpc.CustomerClientServiceBlockingStub customerClientServiceBlockingStub,
						   UserMapper userMapper) {
		this.customerClientServiceBlockingStub = customerClientServiceBlockingStub;
		this.userMapper = userMapper;
	}

	@Override
	public User registerUser(User user) {
		CustomerCreateReply customerCreateReply =  customerClientServiceBlockingStub.createCustomer(userMapper.mapToCustomerCreate(user));
		user.setUserId(customerCreateReply.getUserId());
		return user;
	}

	@Override
	public List<User> findAllUserWithName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUserWithPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUserWithEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUserWithUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserWithUserId(String userId) {
		CustomerFetchReply customerFetchReply = customerClientServiceBlockingStub.fetchCustomer(null);
		verifyOnlyOneUserEntity(userId, customerFetchReply.getCustomersList());
		return userMapper.mapTo(customerFetchReply.getCustomers(0));
	}
	
	/**
	 * @param userId
	 * @param usersByUserId
	 */
	private void verifyOnlyOneUserEntity(String userId, List<Customer> usersByUserId) {
		if (usersByUserId.isEmpty()) {
			throw new RuntimeException("No user found with id [" + userId + "]");
		}
		
		if (usersByUserId.stream().count() != 1) {
			log.error("For username [{}] found userIds [{}]", userId, 
					usersByUserId.stream().map(Customer::getEmail).collect(Collectors.joining(", ")));
			throw new RuntimeException("More than 1 user found with id [" + userId + "]");
		}
	}

}
