package com.project02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.project02.model.UserComment;

//@CrossOrigin(origins = "http://localhost:4200")
@Repository(value="userCommentRepository")
public interface UserCommentRepository extends JpaRepository<UserComment, Integer> {
	public List<UserComment> findAll();
}
