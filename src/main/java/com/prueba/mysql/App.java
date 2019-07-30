package com.prueba.mysql;

import com.prueba.mysql.models.User;
import com.prueba.mysql.models.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) { SpringApplication.run(App.class, args); }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            // fetch all customers
            log.info("User found with findAll():");
            log.info("-------------------------------");
            for (User customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            repository.findById(1)
                    .ifPresent(customer -> {
                        log.info("User found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(customer.toString());
                        log.info("");
                    });

            // fetch customers by last name
            log.info("User found with findById(1):");
            log.info("--------------------------------------------");

            Optional<User> user = repository.findById(1);
            if (user.isPresent()) log.info(user.get().toString());
            log.info("");
        };
    }


}
