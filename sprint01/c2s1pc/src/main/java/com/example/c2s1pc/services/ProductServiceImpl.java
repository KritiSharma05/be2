package com.example.c2s1pc.services;

import com.example.c2s1pc.domain.Product;
import com.example.c2s1pc.repository.ProductRepository;
import com.sun.xml.bind.annotation.OverrideAnnotationOf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository userRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Product saveUser(Product product)  {
        return userRepository.save(product);
    }
    @Override
    public List<Product> getAllUsers() {
        return (List<Product>) userRepository.findAll();
    }

    @Override
    public boolean deleteUserByEmail(int pid) {
        userRepository.deleteById(pid);
        return true;
    }




}
