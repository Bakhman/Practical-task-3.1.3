package com.bakh.practice.springbootstrapdemo.controller;

import com.bakh.practice.springbootstrapdemo.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Bakhmai Begaev
 */
@Controller
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }



    @GetMapping("/user")
    public String toUserPage(Model model) {
        model.addAttribute("user", userService.findUser());
        return "get-user";
    }
}
