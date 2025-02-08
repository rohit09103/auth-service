package com.localhost.auth.entity;


import java.util.Objects;

import com.localhost.auth.enums.DeviceStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_auth_device")
@IdClass(UserAuthDeviceKey.class)
public class UserDeviceEntity {
	
	@Id
	@Column
	private String userName;
	
	@Id
	@Column
	private String deviceId;
	
	@Enumerated
	private DeviceStatus deviceStatus;
	
	@ManyToOne
	private AuthEntity authEntity;

	/**
	 * @return the deviceStatus
	 */
	public DeviceStatus getDeviceStatus() {
		return deviceStatus;
	}

	/**
	 * @param deviceStatus the deviceStatus to set
	 */
	public void setDeviceStatus(DeviceStatus deviceStatus) {
		this.deviceStatus = deviceStatus;
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
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(deviceId, deviceStatus, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof UserDeviceEntity)) {
			return false;
		}
		UserDeviceEntity other = (UserDeviceEntity) obj;
		return Objects.equals(deviceId, other.deviceId) && deviceStatus == other.deviceStatus
				&& Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return String.format("UserDeviceEntity [userName=%s, deviceId=%s, deviceStatus=%s]", userName, deviceId,
				deviceStatus);
	}

}
