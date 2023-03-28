package com.example.c2s3d.services;

import com.example.c2s3d.domain.Customer;
import com.example.c2s3d.exception.CustomerAlreadyExistsException;
import com.example.c2s3d.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    Customer saveCustomerDetail(Customer customer) throws CustomerAlreadyExistsException;
    boolean deleteCustomer(int id) throws CustomerNotFoundException;
    List<Customer> getAllCustomerDetail() throws Exception;
    List<Customer> getAllCustomersByCity(String city) throws CustomerNotFoundException;
}

