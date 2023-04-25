package com.example.bachatgat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bachatgat.entities.User;
import com.example.bachatgat.repository.UserRepository;
import com.example.bachatgat.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User postAllData(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

}
