package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;


import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController	
@RequestMapping("/api/users")
public class UserControllerImpl implements UserController {

	   @Autowired
	   private UserService userService;

	   @PostMapping("/add")
	   public ResponseEntity<String> registerUser(@Valid @RequestBody UserEntity userToInsert) {
	        userService.registerNewUser(userToInsert);
	        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
	   }

	   @GetMapping("/all")
	   public ResponseEntity<List<UserEntity>> getAllUsers() {
	        List<UserEntity> users = userService.getAllUsers();
	        return ResponseEntity.status(HttpStatus.FOUND).body(users);

	   }
	   
	   @GetMapping("/{id}")
	    public ResponseEntity<UserEntity> getUserById(@Valid @PathVariable Integer id) {
	        UserEntity user = userService.getUserById(id);
	        return new ResponseEntity<>(user, HttpStatus.OK);
	    }
	   
	   @PutMapping("/{id}")
	    public ResponseEntity<String> updateUser(@PathVariable Integer id, @Valid @RequestBody UserEntity userDetails) {
	        userService.updateUserDetails(id, userDetails);
	        return new ResponseEntity<>("User details updated successfully", HttpStatus.OK);
	    }

	   
	   @DeleteMapping("/{id}")
	    public ResponseEntity<String> removeUser(@PathVariable Integer id) {
	        userService.removeUserDetails(id);
	        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
	    }
	   
	  

}
