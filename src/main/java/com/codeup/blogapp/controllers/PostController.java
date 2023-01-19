package com.codeup.blogapp.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @RequestMapping(path = "/post" , method = RequestMethod.GET)
    @ResponseBody
    public String post(){
        return "Posts index page ";
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

    @PostMapping("/post/create")
    @ResponseBody
    public String postCreate(){
        return "create a post ";
    }

}
