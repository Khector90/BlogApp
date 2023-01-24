package com.codeup.blogapp.controllers;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

import java.util.Random;
@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String showDiceRoll(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String rollDice(@PathVariable int n, Model model) {
        Random rand = new Random();
        int randomNum = rand.nextInt(6) + 1;
        model.addAttribute("n", n);
        model.addAttribute("randomNum", randomNum);
        return "roll-dice";
    }
    @PostMapping("/roll-dice")
    public void result(@RequestParam(name = "guess") int guess, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/roll-dice/" + guess);
    }


    }


