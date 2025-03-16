package com.ghani.Bloging.Post.PostController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ghani.Bloging.Post.PostServcice.PostService;
import com.ghani.Bloging.Post.model.Post;

@RestController
@RequestMapping("/post")
public class PostController {

    private PostService postservice;

    public PostController(PostService postservice) {
        this.postservice = postservice;

    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getPosts() {
        return new ResponseEntity<>(postservice.getAllPost(), HttpStatus.OK);
    }

    // get post by id
    @GetMapping("/post/{id}")
    public ResponseEntity<Post> getPostByid(@PathVariable Long id) {
        return new ResponseEntity<>(postservice.getPostById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> testing(@RequestBody Post post) {
        System.out.println(post);
        return new ResponseEntity<>("in postmethod", HttpStatus.OK);

    }

    // add a post

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        try {
            System.out.println(post);
            Post createdPost = postservice.addPost(post);
            return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // update a Post
    @PutMapping("/update")
    public ResponseEntity<Post> updatePost(@RequestBody Post post) {
        return new ResponseEntity<>(postservice.updatePost(post), HttpStatus.OK);
    }

    // delete a post
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        postservice.deletePost(id);
        return new ResponseEntity<>("the post is delete...", HttpStatus.OK);
    }
}
