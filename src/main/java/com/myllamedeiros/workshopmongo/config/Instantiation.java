package com.myllamedeiros.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.myllamedeiros.workshopmongo.domain.Post;
import com.myllamedeiros.workshopmongo.domain.User;
import com.myllamedeiros.workshopmongo.dto.AuthorDTO;
import com.myllamedeiros.workshopmongo.dto.CommentDTO;
import com.myllamedeiros.workshopmongo.repository.PostRepository;
import com.myllamedeiros.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository rep;
	
	@Autowired
	private PostRepository postRep;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		rep.deleteAll();
		postRep.deleteAll();
		
		User pax = new User(null, "Pax Augustus", "thesonoftherising@gmail.com"); 
		User electra = new User(null, "Electra Barca-Julii", "littledemon@gmail.com"); 
		User lyria = new User(null, "Lyria of Lagalos", "trufflepig@gmail.com"); 
		
		rep.saveAll(Arrays.asList(pax,electra,lyria));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Nave da República", "Aprendendo a pilotar. Vlw Orion!", new AuthorDTO(pax));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Aprendendo com a Soberana", "Vou ter que assumir isso um dia então é melhor aprender :|", new AuthorDTO(pax));

		CommentDTO c1 = new CommentDTO("Vai destruir a nave haha!", sdf.parse("21/03/2018"), new AuthorDTO(electra));
		CommentDTO c2 = new CommentDTO("Você tem que me ensinar depois, não sei muito bem ainda :/", sdf.parse("22/03/2018"), new AuthorDTO(lyria));
		CommentDTO c3 = new CommentDTO("Que o Reaper nos ajude!!", sdf.parse("23/03/2018"), new AuthorDTO(electra));

		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRep.saveAll(Arrays.asList(post1,post2));
	
		pax.getPosts().addAll(Arrays.asList(post1,post2));
		
		rep.save(pax);
	}

}
