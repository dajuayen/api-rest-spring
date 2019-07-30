package com.prueba.mysql.controllers;

import com.prueba.mysql.models.Customer;
import com.prueba.mysql.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/")
    @ResponseBody
    public Iterable<Customer> customers() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Customer read(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping(path = "/create")
    @ResponseBody
    public Customer create(@RequestParam String firstName, @RequestParam String lastName) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        Long id = service.insert(customer);
        customer.setId(id);
        return customer;
    }

    @PostMapping(path = "/update/{id}")
    @ResponseBody
    public Customer update(@PathVariable Long id, @RequestParam Optional<String> firstName, @RequestParam Optional<String> lastName) {
        // This returns a JSON or XML with the users
        Customer customer = service.findById(id);
        if (firstName.isPresent() && !firstName.get().isEmpty()) customer.setFirstName(firstName.get());
        if (lastName.isPresent() && !lastName.get().isEmpty()) customer.setLastName(lastName.get());
        service.update(customer);
        return customer;
    }

    @DeleteMapping(path = "/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable Long id) {
        // This returns a JSON or XML with the users
        try{
            service.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }catch (Exception ex){
            return ResponseEntity.notFound().build();
        }
    }

}
