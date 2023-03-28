package com.example.c2s1pc.controller;

import com.example.c2s1pc.domain.Product;
import com.example.c2s1pc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1")
public class ProductController {
    private ProductService userService;
    @Autowired
    public ProductController(ProductService userService) {
        this.userService = userService;

    }
    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody Product product){
        return new ResponseEntity<>(userService.saveUser(product), HttpStatus.CREATED);
    }
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {

        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.FOUND);
    }
    @DeleteMapping("/user/{pid}")
    public ResponseEntity<?> deleteUser(@PathVariable int pid){
        return new ResponseEntity<>(userService.deleteUserByEmail(pid), HttpStatus.OK);
    }




}
