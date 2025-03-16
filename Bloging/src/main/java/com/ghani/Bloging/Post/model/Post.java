package com.ghani.Bloging.Post.model;

import java.text.DateFormat;

import com.ghani.Bloging.User.model.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    // private DateFormat createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // getters and setters
    public Post(Long id, String title, String content, DateFormat createdAt, User user) {
        this.title = title;
        this.content = content;
        // this.createdAt = createdAt;
        this.user = user;
    }

    public Post() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // public void setCreatedAt(DateFormat createdAt) {
    // this.createdAt = createdAt;
    // }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    // public DateFormat getCreatedAt() {
    // return createdAt;
    // }

    public User getUser() {
        return user;
    }
}
