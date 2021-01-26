package com.twittr.app.services;

import com.twittr.app.model.User;
import com.twittr.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(long userId) {
        return userRepository.getOne(userId);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
