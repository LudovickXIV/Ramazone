package com.ramazone.ramazone.controllers;

import com.ramazone.ramazone.dto.UserDTO;
import com.ramazone.ramazone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrarionController {
    @Autowired
    private UserService service;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(UserDTO user) {
        service.addUser(user);
        return "redirect:/login";
    }
}
