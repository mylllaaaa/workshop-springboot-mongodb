package com.myllamedeiros.workshopmongo.services;

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
	
}

