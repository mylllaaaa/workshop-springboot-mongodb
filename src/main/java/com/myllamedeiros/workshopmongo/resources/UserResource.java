package com.myllamedeiros.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myllamedeiros.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@RequestMapping(method = RequestMethod.GET) //ou @GetMapping
	public ResponseEntity<List<User>> findAll(){ //para respostas http
		User pax = new User("1", "Pax Augustus", "thesonoftherising@gmail.com");
		User electra = new User("2", "Electra Barca-Julii", "littledemon@gmail.com");

		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(pax, electra));
		
		return ResponseEntity.ok().body(list);
	}
	
}
