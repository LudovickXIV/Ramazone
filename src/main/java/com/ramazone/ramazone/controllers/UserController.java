package com.ramazone.ramazone.controllers;

import com.ramazone.ramazone.dto.UserDTO;
import com.ramazone.ramazone.model.user.User;
import com.ramazone.ramazone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@PreAuthorize("hasAuthority('ADMIN')")
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/")
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @PostMapping
    public String insertUser(@RequestBody UserDTO user) {
        service.addUser(user);
        return "redirect:/user";
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id) {
        service.deleteUser(id);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id) {
        return service.getUser(id);
    }

    @GetMapping("/users")
    public List<UserDTO> getAll(){
        return service.getAllUsers();
    }

}
