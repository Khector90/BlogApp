package com.codeup.blogapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/{name}")
    @ResponseBody
    public String welcomePage(@PathVariable String name){
        return "Hello " + name + " This is the landing area!";
    }
}
