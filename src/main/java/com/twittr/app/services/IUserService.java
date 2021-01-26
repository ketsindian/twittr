package com.twittr.app.services;


import com.twittr.app.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    public User getUserById(long userId);

    public User createUser(User user);
}
