/**
 * 
 */
package com.localhost.auth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.localhost.auth.entity.UserEntity;

/**
 * 
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

}
