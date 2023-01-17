package com.codeup.blogapp;

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




}
