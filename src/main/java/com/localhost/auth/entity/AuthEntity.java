package com.localhost.auth.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_auth")
public class AuthEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String userName;
	@Column
	private String password;
	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "authEntity")
	private List<UserDeviceEntity> userDeviceEntity;
	@Column
	private String userId;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return the userDeviceEntity
	 */
	public List<UserDeviceEntity> getUserDeviceEntity() {
		return userDeviceEntity;
	}

	/**
	 * @param userDeviceEntity the userDeviceEntity to set
	 */
	public void setUserDeviceEntity(List<UserDeviceEntity> userDeviceEntity) {
		this.userDeviceEntity = userDeviceEntity;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, password, userDeviceEntity, userId, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AuthEntity)) {
			return false;
		}
		AuthEntity other = (AuthEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(password, other.password)
				&& Objects.equals(userDeviceEntity, other.userDeviceEntity) && Objects.equals(userId, other.userId)
				&& Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return String.format("AuthEntity [id=%s, userName=%s, password=%s, userDeviceEntity=%s, userId=%s]", id,
				userName, password, userDeviceEntity, userId);
	}


}
