package com.myllamedeiros.workshopmongo.services;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myllamedeiros.workshopmongo.domain.User;
import com.myllamedeiros.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository rep;

	public List<User> findAll(){
		return rep.findAll();
	}
}
