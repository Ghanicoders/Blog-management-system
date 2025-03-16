package com.ghani.Bloging.Post.PostServcice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ghani.Bloging.Post.PostRepo.PostRepo;
import com.ghani.Bloging.Post.model.Post;
import com.ghani.Bloging.User.DAO.UserRepo;

@Service
public class PostService {

    private PostRepo postRepo;
    private UserRepo userRepo;

    public PostService(PostRepo postRepo, UserRepo userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    public List<Post> getAllPost() {
        return postRepo.findAll();

    }

    public Post getPostById(Long id) {
        return postRepo.findById(id).orElse(new Post());
    }

    public Post createPost(Post post) {
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        // Date date = sdf.parse(post.getCreatedAt());

        post.setUser(
                userRepo.findById(post.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found")));
        return postRepo.save(post);
    }

    public Post addPost(Post post) {
        return postRepo.save(post);
    }

    public Post updatePost(Post post) {
        return postRepo.save(post);
    }

    public void deletePost(Long id) {
        postRepo.deleteById(id);
    }
}
