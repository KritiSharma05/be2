package com.example.c2s1pc.services;

import com.example.c2s1pc.domain.Product;

import java.util.List;

public interface ProductService {
    Product saveUser(Product product) ;
    List<Product> getAllUsers();
    boolean deleteUserByEmail(int pid);
}
