package com.project02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project02.model.UserComment;
import com.project02.repository.UserCommentRepository;

@Service(value="userCommentService")
public class UserCommentService {
	
	@Autowired
	UserCommentRepository userCommentRepository;
	
	public List<UserComment> getAllUserComments() {
		return this.userCommentRepository.findAll();
	}

}
