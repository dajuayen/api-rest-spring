package com.prueba.mysql.services;

import com.prueba.mysql.models.Customer;
import com.prueba.mysql.models.repositories.CustomerRepository;
import com.prueba.mysql.models.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    public List<Customer> findAll(){
        return (List<Customer>) repository.findAll();
    }

    public Customer findById(Long id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No user found with id: [" + id +  "]"));
    }

    public Long insert (Customer customer){
        return repository.save(customer).getId();
    }

    public Long update (Customer customer){
        return repository.save(customer).getId();
    }

    public void deleteById(Long id){
        repository.findById(id).map(customer -> {
            repository.delete(customer);
            return true;
        }).orElseThrow(() -> new ResourceNotFoundException("Customer " + id + " not found"));
    }

}
