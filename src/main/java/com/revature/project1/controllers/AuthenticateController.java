package com.revature.project1.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project1.models.User;
import com.revature.project1.models.UsernamePasswordAuthentication;
import com.revature.project1.services.UserService;

@RestController
public class AuthenticateController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> authenticate(@RequestBody UsernamePasswordAuthentication user, HttpSession session) {

        User userAuthenticated = this.userService.getUserByUsername(user);
        session.setAttribute("user", userAuthenticated.getUsername());
        return new ResponseEntity<>(userAuthenticated, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UsernamePasswordAuthentication user) {

        return new ResponseEntity<>(this.userService.registerUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {

        session.invalidate();
        return new ResponseEntity<>("Successfully logged out", HttpStatus.OK);
    }

}
