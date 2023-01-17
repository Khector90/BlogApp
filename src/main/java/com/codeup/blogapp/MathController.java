package com.codeup.blogapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    @GetMapping("/add{a}/and/{b}")
    public int add(@PathVariable int a, @PathVariable int b){
        return a + b;
    }

    @GetMapping("/subtract/{a}/from/{b}")
    public int subtract(@PathVariable int a, @PathVariable int b) {
        return b - a;
    }

    @GetMapping("/multiply/{a}/and/{b}")
    public int multiply(@PathVariable int a, @PathVariable int b) {
        return a * b;
    }

    @GetMapping("/divide/{a}/by/{b}")
    public int divide(@PathVariable int a, @PathVariable int b) {
        return a / b;
    }
}
