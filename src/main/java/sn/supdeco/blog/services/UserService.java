package sn.supdeco.blog.services;

import org.springframework.stereotype.Service;

import sn.supdeco.blog.models.User;

@Service
public interface UserService {
    User create(User user);
    User login(String username, String password);
}
