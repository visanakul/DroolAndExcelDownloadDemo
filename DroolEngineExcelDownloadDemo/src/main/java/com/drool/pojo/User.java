package com.drool.pojo;

import lombok.Data;

@Data
public class User {
	private String userName;
	private String email;
	private String mobile;

	public User() {
	}

	public User(String userName, String email, String mobile) {
		super();
		this.userName = userName;
		this.email = email;
		this.mobile = mobile;
	}

}
