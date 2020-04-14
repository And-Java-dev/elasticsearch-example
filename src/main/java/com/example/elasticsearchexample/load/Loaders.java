package com.example.elasticsearchexample.load;

import com.example.elasticsearchexample.jpaRepository.UsersJpaRepository;
import com.example.elasticsearchexample.model.User;
import com.example.elasticsearchexample.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class Loaders {

    @Autowired
    private ElasticsearchOperations operations;

    @Autowired
    private UsersJpaRepository usersJpaRepository;

    @Autowired
    private UsersRepository usersRepository;

    @PostConstruct
    @Transactional
    public void loadAll() {
        operations.putMapping(User.class);
        List<User> data = getData();
        usersJpaRepository.save(data);

        List<User> all = usersJpaRepository.findAll();
        usersRepository.save(data);

    }

    private List<User> getData() {

        List<User> users = new ArrayList<>();
        users.add(new User(123L,"Example","And", 1000L));
        users.add(new User(124L,"Example1","Dav", 200L));
        users.add(new User(125L,"Example2","So", 1080L));
        users.add(new User(126L,"Example3","Hos", 50000L));
        users.add(new User(127L,"Example4","Vle", 1L));
        users.add(new User(128L,"Example5","Din", 104L));
        users.add(new User(129L,"Example6","Jor", 20L));
        return users;
    }
}
