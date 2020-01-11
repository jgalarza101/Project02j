package com.project02.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project02.model.Posts;
import com.project02.service.PostsService;
//import com.project02.service.UserService;

@RestController(value="postsController")
@RequestMapping(value="/posts")
@CrossOrigin(origins = "http://localhost:4200")
public class PostsController {
	
	private static PostsService postsService;
	
	@Autowired
	public void setPostsService(PostsService postsService) {
		PostsController.postsService = postsService;
	}
	
	@GetMapping(value="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Posts> getAllPosts(){
		return PostsController.postsService.getAllPosts();
	}

}
