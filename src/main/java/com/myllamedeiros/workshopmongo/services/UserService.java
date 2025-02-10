package com.myllamedeiros.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myllamedeiros.workshopmongo.domain.User;
import com.myllamedeiros.workshopmongo.repository.UserRepository;
import com.myllamedeiros.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository rep;

	public List<User> findAll(){
		return rep.findAll();
	}
	
	public User findById(String id) {
	    return rep.findById(id)
	              .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
	}
}

