package com.project02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.project02.model.Posts;

@Repository(value="postsRepository")
public interface PostsRepository extends JpaRepository<Posts, Integer>{
	public List<Posts> findAll();

}
