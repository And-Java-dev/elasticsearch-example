package com.example.elasticsearchexample.repository;

import com.example.elasticsearchexample.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import java.util.List;

public interface UsersRepository extends ElasticsearchCrudRepository<User, Long> {

    List<User> findByName(String name);

    List<User> findBySalary(Long salary);

}
