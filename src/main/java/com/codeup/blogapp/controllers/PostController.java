package com.codeup.blogapp.controllers;

import com.codeup.blogapp.models.Post;
import com.codeup.blogapp.repositories.PostRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostRepository postDao;
    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }
//    @RequestMapping(path = "/post" , method = RequestMethod.GET)
//    @ResponseBody
//    public String post(){
//        return "Posts index page ";
//    }

    @RequestMapping(path = "/post/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public String postID(@PathVariable int id){
        return "view an individual post " + id;
    }
//    looked for  short hand way to find the answer
    @GetMapping("/create")
    public String createForm() {
        return "view the form for creating a post";
    }

    @PostMapping("/post/create")
    @ResponseBody
    public String postCreate(){
        return "create a post ";
    }

    @GetMapping("/posts")
    public String getPost(Model model){
        List<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/show";
    }




}
