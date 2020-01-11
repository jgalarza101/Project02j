package com.project02.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project02.model.User;
import com.project02.model.UserComment;
import com.project02.service.UserCommentService;
import com.project02.service.UserService;

@RestController(value="usercommentController")
@RequestMapping(value="/usercomment")
@CrossOrigin(origins = "http://localhost:4200")
public class UserCommentController {
	
	private static UserCommentService userCommentService;
	
	@Autowired
	public void setUserCommentService(UserCommentService userCommentService) {
		UserCommentController.userCommentService = userCommentService;
	}
	
	@GetMapping(value="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<UserComment> getAllUserComments(){
		return UserCommentController.userCommentService.getAllUserComments();
	}

}
