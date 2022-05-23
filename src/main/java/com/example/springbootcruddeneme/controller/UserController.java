package com.example.springbootcruddeneme.controller;

import com.example.springbootcruddeneme.model.User;
import com.example.springbootcruddeneme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
// @Profile("mysql")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getAllUser(@RequestParam(required = false) String firstName) {
        List<User> allUser = userService.findAllUser(firstName);
        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserId(@PathVariable Long id) {
        User userById = userService.getUserById(id);
        return new ResponseEntity<>(userById, HttpStatus.CREATED);
    }


    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User saveUser = userService.saveUser(user);
        return new ResponseEntity<User>(saveUser, HttpStatus.CREATED);
    }

  /*
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUserById(@RequestBody User user) {
        User updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }
   */

  @PutMapping("/update/{id}")
  public ResponseEntity<Void>updateUserById(@PathVariable Long id,@RequestBody User newUser){
      userService.updateUser(id,newUser);
      return new ResponseEntity<>(HttpStatus.OK);
  }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
