package com.brownford.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;
import org.springframework.ui.Model;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/forgot-password")
    public String forgotPassword() {
        return "forgot-password";
    }

    private static final Map<String, String> USERS = Map.of(
            "admin", "password",
            "user1", "pass123",
            "asd", "asd");

    @PostMapping("/login")
    public String login(@RequestParam String username,
            @RequestParam String password,
            Model model) {
        if (USERS.containsKey(username) && USERS.get(username).equals(password)) {
            return "redirect:/home"; // Redirect if valid user
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login"; // Stay on login page
        }
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

}
