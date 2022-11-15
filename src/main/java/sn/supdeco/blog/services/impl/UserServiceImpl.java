package sn.supdeco.blog.services.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sn.supdeco.blog.models.User;
import sn.supdeco.blog.repositories.UserRepository;
import sn.supdeco.blog.services.UserService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    
    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password).orElse(null);
    }
    
}
