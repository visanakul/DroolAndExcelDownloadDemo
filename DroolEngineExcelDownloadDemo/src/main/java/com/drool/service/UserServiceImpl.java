package com.drool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.drool.pojo.User;

@Service
public class UserServiceImpl implements IUserService{

	@Override
	public List<User> getAllUsers() {
		List<User> users=new ArrayList<User>();
		users.add(new User("user1", "user1@gmail.com", "9812345678"));
		users.add(new User("user2", "user2@gmail.com", "9812345679"));
		users.add(new User("user3", "user3@gmail.com", "9812345677"));
		return users;
	}

}
