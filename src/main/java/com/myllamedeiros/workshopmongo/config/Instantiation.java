package com.myllamedeiros.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.myllamedeiros.workshopmongo.domain.User;
import com.myllamedeiros.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository rep;
	
	@Override
	public void run(String... args) throws Exception {
		rep.deleteAll();
		
		User pax = new User(null, "Pax Augustus", "thesonoftherising@gmail.com"); 
		User electra = new User(null, "Elextra Barca-Julii", "littledemon@gmail.com"); 
		User lyria = new User(null, "Lyria of Lagalos", "trufflepig@gmail.com"); 
		
		rep.saveAll(Arrays.asList(pax,electra,lyria));
	}

}
