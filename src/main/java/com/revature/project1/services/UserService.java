package com.revature.project1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project1.exceptions.IncorrectPasswordException;
import com.revature.project1.exceptions.NotFoundException;
import com.revature.project1.models.User;
import com.revature.project1.models.UsernamePasswordAuthentication;
import com.revature.project1.repository.UserDao;

@Service
public class UserService {

    @Autowired
    private UserDao dao;

    public User getUserByUsername(String username, String password) {

        Optional<User> user = this.dao.findByUsername(username);

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();
        } else if (user.isEmpty()) {
            throw new NotFoundException("User not found");
        } else {
            throw new IncorrectPasswordException();
        }
    }

    public User registerUser(UsernamePasswordAuthentication registerAccount) {

        this.dao.createUser(registerAccount.getUsername(), registerAccount.getPassword());
        return this.dao.findByUsername(registerAccount.getUsername()).get();
    }

}
