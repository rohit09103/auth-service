/**
 * 
 */
package com.localhost.auth.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.localhost.auth.entity.AuthEntity;

/**
 * 
 */
@Repository
public interface AuthRepository extends CrudRepository<AuthEntity, Integer> {
	
	
	List<AuthEntity> findAllByUserName(String userName);
	List<AuthEntity> findAllByUserId(String userId);

}
