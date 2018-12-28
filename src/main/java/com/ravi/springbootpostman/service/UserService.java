package com.ravi.springbootpostman.service;

import com.ravi.springbootpostman.bean.User;

public interface UserService {
	
	 User findByName(String name);
	 void saveUser(User user);
}
