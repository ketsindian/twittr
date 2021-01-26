package com.twittr.app.controller;

import com.twittr.app.model.User;
import com.twittr.app.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{userId}")
    public User getUser(@Validated @PathVariable long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/user")
    public User createUser(@Validated @RequestBody User user) {
        return userService.createUser(user);
    }
}
