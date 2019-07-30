package com.prueba.mysql.services;


import com.prueba.mysql.models.User;
import com.prueba.mysql.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> findAll(){
        return (List<User>) repository.findAll();
    }

    public User findById(int id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No user found with id: [" + id +  "]"));
    }

    public long insert (User user){
        return repository.save(user).getId();
    }

    public long update (User user){
        return repository.save(user).getId();
    }

    public void deleteById(int id){
        repository.deleteById(id);
    }

}
