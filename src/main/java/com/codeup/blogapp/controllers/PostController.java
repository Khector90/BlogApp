package com.codeup.blogapp.controllers;

import com.codeup.blogapp.models.Post;
import com.codeup.blogapp.models.User;
import com.codeup.blogapp.repositories.PostRepository;
import com.codeup.blogapp.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }


    @GetMapping(path = "/post/{id}")
    public String postID(@PathVariable int id, Model model){
        Post currentPost = postDao.getReferenceById((long) id);
        model.addAttribute("post", currentPost);
        return "posts/post";
    }


//    WAY WITHOUT FORM MODEL BINDING

//    @GetMapping("/posts/create")
//    public String createForm()
//    {
//        return "posts/create";
//    }
//
//    @PostMapping("/posts/create")
//    public String postCreate(@RequestParam(name = "username") String username,@RequestParam(name="title") String title, @RequestParam(name = "body")String body)
//    {
//        System.out.println(username);
//        Post post = new Post();
//        User user =userDao.findByUsername(username);
//        post.setTitle(title);
//        post.setBody(body);
//        post.setUser(user);
//        postDao.save(post);
//
//        return "redirect:/posts";
//    }

    @GetMapping("/posts")
    public String getPost(Model model){
        List<Post> posts = postDao.findAll();
        for (Post post: posts){
            System.out.println(post.getUser().getUsername());
        }
        model.addAttribute("posts", posts);
        return "posts/show";
    }
//---------------------------Form model binding here-------------------------
    @GetMapping("/posts/create")
    public String postCreate(Model model){
        model.addAttribute("postToCreate", new post());
        return "posts/create";

    }

    @PostMapping("/ads/create")
    public String postCreate(@ModelAttribute Post postCreate){
        User user =userDao.getReferenceById(1L);
        postCreate.setUser(user);
        postDao.save(postCreate);
        return "redirect:/posts";
    }
//---------------------------Form model binding here-------------------------

}
