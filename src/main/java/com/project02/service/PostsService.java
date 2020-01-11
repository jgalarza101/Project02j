package com.project02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project02.model.Posts;
import com.project02.repository.PostsRepository;

@Service(value="postsService")
public class PostsService {
	
	@Autowired
	PostsRepository postsRepository;
	
	public List<Posts> getAllPosts() {
		return this.postsRepository.findAll();
	}

}
