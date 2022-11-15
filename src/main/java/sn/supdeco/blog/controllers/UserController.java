package sn.supdeco.blog.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sn.supdeco.blog.models.User;
import sn.supdeco.blog.services.UserService;
import sn.supdeco.blog.services.dtos.UserLoginDto;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    
    @PostMapping("")
    public ResponseEntity<User> createUSer(@RequestBody User user) {
        return ResponseEntity.ok(userService.create(user));
    }


    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserLoginDto user){
        return ResponseEntity.ok(userService.login(user.getUsername(), user.getPassword()));
    }

}
