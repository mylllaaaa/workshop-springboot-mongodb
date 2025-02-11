package com.myllamedeiros.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myllamedeiros.workshopmongo.domain.User;
import com.myllamedeiros.workshopmongo.dto.UserDTO;
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
	
	public User insert(User obj) {
		return rep.insert(obj);
	}
	
	public void delete(String id) {
		findById(id); //pra ver se ele existe
		rep.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return rep.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}

