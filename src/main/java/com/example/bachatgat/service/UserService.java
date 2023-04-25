package com.example.bachatgat.service;

import java.util.List;

import com.example.bachatgat.entities.User;

public interface UserService {

public List<User> getAllData();
	
	public User postAllData(User user);
}
