package com.revature.project1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project1.exceptions.NotMatchingException;
import com.revature.project1.models.User;
import com.revature.project1.models.UsernamePasswordAuthentication;
import com.revature.project1.repository.UserDao;

@Service
public class UserService {

    @Autowired
    private UserDao dao;

    public User getUserByUsername(UsernamePasswordAuthentication user) {

        Optional<User> optionalUser = this.dao.findUserByUsername(user.getUsername());

        if (optionalUser.isPresent() && optionalUser.get().getPassword().equals(user.getPassword())) {
            return optionalUser.get();
        } else if (optionalUser.isEmpty()) {
            throw new NotMatchingException("User not found");
        } else {
            throw new NotMatchingException("Incorrect password");
        }
    }

    public String registerUser(UsernamePasswordAuthentication registerAccount) {

        this.dao.createUser(registerAccount.getUsername(), registerAccount.getPassword());
        return "Registration successful";
    }

}
