package sn.supdeco.blog.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sn.supdeco.blog.models.BlogUserDetails;
import sn.supdeco.blog.models.User;
import sn.supdeco.blog.repositories.UserRepository;

@Service
public class BlogUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);
        userOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found : " + username));
        System.out.println("User : " + userOptional.get());
        return userOptional.map(BlogUserDetails::new).get();
    }
    
}
