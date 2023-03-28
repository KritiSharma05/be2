package com.example.c2s3d.repository;

import com.example.c2s3d.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer,Integer> {
    @Query("{'customerAddress.city' : {$in : [?0]}}")
    List<Customer> findAllCustomerFromCity(String city);
}

