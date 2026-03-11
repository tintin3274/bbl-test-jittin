package com.example.bbl_test_jittin.controller;

import com.example.bbl_test_jittin.model.User;
import com.example.bbl_test_jittin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable long userId) {
        User user = userService.getUser(userId);
        if (user == null) {
            return ResponseEntity.status(HttpStatusCode.valueOf(404))
                    .body(null);
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User userRequest) throws Exception {
        try {
            return ResponseEntity.status(HttpStatusCode.valueOf(201))
                    .body(userService.createUser(userRequest));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatusCode.valueOf(400))
                    .body(e.getMessage());
        }
    }


    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable long userId, @RequestBody User userRequest) throws Exception {
        try {
            User user = userService.updateUser(userId, userRequest);
            if (user == null) {
                return ResponseEntity.status(HttpStatusCode.valueOf(404))
                        .body(null);
            }
            return ResponseEntity.ok(user);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatusCode.valueOf(400))
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable long userId) {
        User user = userService.deleteUser(userId);
        if (user == null) {
            return ResponseEntity.status(HttpStatusCode.valueOf(404))
                    .body(null);
        }
        return ResponseEntity.ok(user);
    }
}
