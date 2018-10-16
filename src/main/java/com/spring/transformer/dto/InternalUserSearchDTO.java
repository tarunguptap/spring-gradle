package com.spring.transformer.dto;

import java.io.Serializable;

public class InternalUserSearchDTO implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Long userId;
	
	private String username;
	
	private String password;
	
	private Boolean active;
	
	private long deleted;
	
	private String Role;

	public InternalUserSearchDTO() {
		
	}
	
	public InternalUserSearchDTO(Long userId, String username, String password,
			Boolean active, long deleted, String role) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.active = active;
		this.deleted = deleted;
		Role = role;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public long getDeleted() {
		return deleted;
	}

	public void setDeleted(long deleted) {
		this.deleted = deleted;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}
	
	
}
