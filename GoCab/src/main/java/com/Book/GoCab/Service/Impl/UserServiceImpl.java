package com.Book.GoCab.Service.Impl;

import com.Book.GoCab.Model.User;
import com.Book.GoCab.Repository.UserRepository;
import com.Book.GoCab.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }
}
