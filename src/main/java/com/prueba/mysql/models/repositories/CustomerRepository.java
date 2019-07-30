package com.prueba.mysql.models.repositories;

import com.prueba.mysql.models.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Optional<Customer> findByFirstName(String firstName);
    Optional<Customer> findByLastName(String lastName);
    Optional<Customer> findByFirstNameAndLastName(String firstName, String lastName);


}