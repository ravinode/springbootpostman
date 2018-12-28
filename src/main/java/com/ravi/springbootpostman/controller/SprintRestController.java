package com.ravi.springbootpostman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.springbootpostman.bean.User;
import com.ravi.springbootpostman.service.UserService;

@RestController
public class SprintRestController {

	 @Autowired
	 UserService userService;
	
	 @RequestMapping(value = "/user/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<User> getUser(@PathVariable("name") String name) {
	        User user = userService.findByName(name);
	        if (user == null) {
	            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	        }
	        return new ResponseEntity<User>(user, HttpStatus.OK);
	    }
	 
	 @RequestMapping(value = "/addUser", method = RequestMethod.POST)
	    public String addUser(User user) {
	        userService.saveUser(user);
	        return "Success" ;
	    }
}
