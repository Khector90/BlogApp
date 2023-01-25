package com.codeup.blogapp.controllers;

import com.codeup.blogapp.models.Post;
import com.codeup.blogapp.models.User;
import com.codeup.blogapp.repositories.PostRepository;
import com.codeup.blogapp.repositories.UserRepository;
import com.codeup.blogapp.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService){
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
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
////---------------------------Form model binding here-------------------------
    @GetMapping("/posts/create")
    public String postCreate(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";

    }

    @PostMapping("/posts/create")
    public String postCreate(@ModelAttribute Post postCreate){
        User user =userDao.getReferenceById(1L);
        postCreate.setUser(user);
        emailService.preparedAndSend(postCreate, "New post!", "Post has been created");
        postDao.save(postCreate);
        return "redirect:/posts";
    }
//---------------------------Form model binding here-------------------------


    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        Post currentPost = postDao.getReferenceById(id);
        System.out.println(currentPost.getTitle());
        model.addAttribute("post", currentPost);
        return "posts/edit";
    }
    @PostMapping("/posts/edit")
    public String editPost(@ModelAttribute Post post) {
        User user = userDao.findAll().get(0);
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }

}
