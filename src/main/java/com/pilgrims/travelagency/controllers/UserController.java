package com.pilgrims.travelagency.controllers;

import com.pilgrims.travelagency.models.User;
import com.pilgrims.travelagency.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Controller to handle all user related requests
 *
 * @author Ott Pikk
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable UUID id) {
        User user = userService.findUserById(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(user, headers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createUser( @RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<?> findByUserNameAndPassword(@PathVariable String userName, @PathVariable String password) {
        User user = userService.findByUserNameAndPassword(userName, password);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());
        return new ResponseEntity<>(user, headers, HttpStatus.OK);

    }


}






