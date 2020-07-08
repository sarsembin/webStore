package com.store.webStore.controllers;

import com.store.webStore.entity.User;
import com.store.webStore.repos.UserRepository;
import com.store.webStore.service.SecurityService;
import com.store.webStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecurityController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    SecurityService securityService;

    @GetMapping("login")
    public String Login(Model model){
        return "login";
    }

    @GetMapping("register")
    public String Register(Model model){
        return "register";
    }
    @PostMapping("register")
    public String Register(@ModelAttribute("userForm") User userForm){
        userService.save(userForm, "ROLE_USER");
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/login";
    }
}
