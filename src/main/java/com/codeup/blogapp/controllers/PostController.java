package com.codeup.blogapp.controllers;

import com.codeup.blogapp.models.Post;
import com.codeup.blogapp.models.User;
import com.codeup.blogapp.repositories.PostRepository;
import com.codeup.blogapp.repositories.UserRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostRepository postDoa;
    private final UserRepository userDoa;

    public PostController(PostRepository postDoa, UserRepository userDoa){
        this.postDoa = postDoa;
        this.userDoa = userDoa;
    }


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

    @GetMapping ("/posts/create")
    public String createAdPage(){
        return "posts/create";
    }

    @PostMapping("/post/create")
    @ResponseBody
    public String postCreate(@RequestParam(name = "username") String username,@RequestParam(name="title") String title, @RequestParam(name = "body")String body){
        Post post = new Post();
        User user =userDoa.findByUsername(username);
        post.setTitle(title);
        post.setBody(body);
        post.setUser(user);
        postDoa.save(post);

        return "redirect:/posts";
    }

    @GetMapping("/posts")
    public String getPost(Model model){
        List<Post> posts = postDoa.findAll();
        model.addAttribute("posts", posts);
        return "posts/show";
    }




}
