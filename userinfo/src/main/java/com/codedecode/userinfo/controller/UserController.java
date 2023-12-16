package com.codedecode.userinfo.controller;

import com.codedecode.userinfo.dto.UserDTO;
import com.codedecode.userinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO)
    {
        UserDTO saveUser = userService.saveUser(userDTO);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @GetMapping("/fetchUserByUserId/{userId}")
    ResponseEntity<UserDTO> fetchUserByUserId(@PathVariable Integer userId)
    {

        return userService.findUserByUserId(userId);
    }
}
