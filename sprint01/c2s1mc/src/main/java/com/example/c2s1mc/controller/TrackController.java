package com.example.c2s1mc.controller;

import com.example.c2s1mc.domain.Track;
import com.example.c2s1mc.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class TrackController {
    private TrackService userService;
    @Autowired
    public TrackController(TrackService userService) {
        this.userService = userService;

    }
    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody Track user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {

        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.FOUND);
    }

    @DeleteMapping("/user/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable int tid){
        return new ResponseEntity<>(userService.deleteUserByEmail(tid), HttpStatus.OK);
    }
    @PutMapping("/user/{email}")
    public ResponseEntity<?> updateUser(@RequestBody Track track,@PathVariable int tid) {
        return new ResponseEntity<>(userService.updateUser(track,tid), HttpStatus.OK);
    }


}
