package com.example.elasticsearchexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "users", type = "users", shards = 1)
public class User {

    @Id
    private Long id;
    private String teamName;
    private String name;
    private Long salary;

}
