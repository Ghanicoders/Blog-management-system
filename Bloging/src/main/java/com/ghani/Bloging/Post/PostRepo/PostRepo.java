package com.ghani.Bloging.Post.PostRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ghani.Bloging.Post.model.Post;

public interface PostRepo extends JpaRepository<Post, Long> {

}
