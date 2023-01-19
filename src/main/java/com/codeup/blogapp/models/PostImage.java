package com.codeup.blogapp.models;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "post_images")
public class PostImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String path;

    @ManyToMany(mappedBy = "categories")
    private List<Post> posts;

    @ManyToOne
    @JoinColumn(name ="post_id")
    private Post post;

    public PostImage(){

    }

    public PostImage(long id, String path, Post post) {
        this.id = id;
        this.path = path;
        this.post = post;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
