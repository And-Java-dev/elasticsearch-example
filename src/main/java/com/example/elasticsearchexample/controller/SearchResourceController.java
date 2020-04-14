package com.example.elasticsearchexample.controller;

import com.example.elasticsearchexample.model.User;
import com.example.elasticsearchexample.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/search/")
public class SearchResourceController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping(value = "name/{text}")
    public List<User> searchName(@PathVariable final  String text){
        return usersRepository.findByName(text);
    }


    @GetMapping(value = "salary/{salary}")
    public List<User> searchSalary(@PathVariable final  Long salary){
        return usersRepository.findBySalary(salary);
    }

    @GetMapping
    public List<User> searchAll() {
        List<User> users = new ArrayList<>();
        Iterable<User> all = usersRepository.findAll();
        all.forEach(users::add);
        return users;
    }
}
