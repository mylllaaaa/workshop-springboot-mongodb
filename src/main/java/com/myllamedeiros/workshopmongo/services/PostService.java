package com.myllamedeiros.workshopmongo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myllamedeiros.workshopmongo.domain.Post;
import com.myllamedeiros.workshopmongo.repository.PostRepository;
import com.myllamedeiros.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository rep;

	public Post findById(String id) {
	    return rep.findById(id)
	              .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
	}	
	
	public List<Post> findByTitle(String text){
		return rep.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		//maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return rep.fullSearch(text, minDate, maxDate);
	}
	
}

