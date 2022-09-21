package com.bakh.practice.springbootstrapdemo.controller;

import com.bakh.practice.springbootstrapdemo.model.Role;
import com.bakh.practice.springbootstrapdemo.model.User;
import com.bakh.practice.springbootstrapdemo.service.RoleServiceImpl;
import com.bakh.practice.springbootstrapdemo.service.UserServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Bakhmai Begaev
 */
@Controller
@RequestMapping()
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;
    private final BCryptPasswordEncoder passwordEncoder;

    public AdminController(UserService userService, RoleService roleService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String toHomePage() {
        return "homePage";
    }

    @GetMapping("/admin")
    public String toUsersPage(Model model) {
        List<User> users = userService.findAllUsers();
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("users", users);
        model.addAttribute("rolesList", roles);
        model.addAttribute("user", userService.findUser());
        return "admin/user-list";
    }

    @GetMapping("/createUser")
    public String getUserCreationForm(Model model) {
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("currentUser", userService.findUser());
        model.addAttribute("user", new User());
        model.addAttribute("rolesList", roles);
        return "admin/create-user";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute("user")  User user) {
        userService.createUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/update/{id}")
    public String getUserUpdateForm(@PathVariable Long id, Model model) {
        List<Role> roles = roleService.getAllRoles();
        User user = userService.findUser();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        model.addAttribute("myUser", user);
        model.addAttribute("rolesList", roles);
        return "admin/user-list";
    }

    @PatchMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, User user) {
        user.setPassword(user.getPassword());
        userService.editUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }
}
