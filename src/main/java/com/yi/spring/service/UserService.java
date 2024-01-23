package com.yi.spring.service;

import com.yi.spring.mappers.UserMapper;
import com.yi.spring.vo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserMapper userRepository;

    public UserService(UserMapper userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }
}