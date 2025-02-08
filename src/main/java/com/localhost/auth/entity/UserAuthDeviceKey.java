package com.localhost.auth.entity;

import java.io.Serializable;
import java.util.Objects;

public class UserAuthDeviceKey implements Serializable{
	
	private static final long serialVersionUID = -3781082551215647981L;
	private String userName;
	private String deviceId;
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
		return Objects.hash(deviceId, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof UserAuthDeviceKey)) {
			return false;
		}
		UserAuthDeviceKey other = (UserAuthDeviceKey) obj;
		return Objects.equals(deviceId, other.deviceId) && Objects.equals(userName, other.userName);
	}
	@Override
	public String toString() {
		return String.format("UserAuthDeviceKey [userName=%s, deviceId=%s]", userName, deviceId);
	}
	
}
