package com.codeup.blogapp.service;

import com.codeup.blogapp.models.Post;
import com.codeup.blogapp.models.User;
import com.codeup.blogapp.repositories.PostRepository;
import com.codeup.blogapp.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("PostService")
public class PostService {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostService(PostRepository postDao, UserRepository userDao, EmailService emailService){
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    public List<Post> getAllPost(){
        for(Post post: postDao.findAll()){
            System.out.println("Username: " + post.getUser().getUsername());
            System.out.println("Title: " + post.getTitle());
            System.out.println("Body: " + post.getBody());

        }
        return postDao.findAll();
    }

    public Post getPost(long id){
        return postDao.getReferenceById(id);
    }

    public void create(Post post){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        emailService.preparedAndSend(post, post.getTitle(), post.getBody());
        postDao.save(post);
    }


}




