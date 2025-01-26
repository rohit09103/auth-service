/**
 * 
 */
package com.localhost.auth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.localhost.auth.entity.AuthEntity;

/**
 * 
 */
@Repository
public interface AuthRepository extends CrudRepository<AuthEntity, Integer> {

}
