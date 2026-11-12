package com.food.delivery.user_info.controller;

import com.food.delivery.user_info.dto.UserDTO;
import com.food.delivery.user_info.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        UserDTO savedUser = userService.addUser(userDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/fetchUserById/{userId}")
    public ResponseEntity<UserDTO> fetchUserDetailsById(@PathVariable Integer userId) {
        UserDTO fetchedUser = userService.fetchUserDetailsById(userId).getBody();
        return new ResponseEntity<>(fetchedUser, HttpStatus.OK);
    }
}
