package com.ravi.springbootpostman.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ravi.springbootpostman.bean.User;
import com.ravi.springbootpostman.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	 private static List<User> users;
	 
	static{
        users= populateUsers();
    }
	
	@Override
	public User findByName(String name) {
		for(User user : users){
            if(user.getName().equalsIgnoreCase(name)){
                return user;
            }
        }
        return null;
	}

	@Override
	public void saveUser(User user) {
	       users.add(user);
	       // Logic to Save in DB 
		
	}
	
	 private static List<User> populateUsers(){ 
	        List<User> users = new ArrayList<User>();
	        users.add(new User("Ravi","25","Male"));
	        users.add(new User("John","29","Male"));
	        users.add(new User("Max","28","Male"));
	        users.add(new User("Sam,","27","Male"));
	        return users;
	    }
	 

}
