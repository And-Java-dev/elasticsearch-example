package com.example.elasticsearchexample.jpaRepository;

import com.example.elasticsearchexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersJpaRepository  extends JpaRepository<User, Long> {
}
