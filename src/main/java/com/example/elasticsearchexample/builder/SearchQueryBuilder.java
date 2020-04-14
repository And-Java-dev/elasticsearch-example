package com.example.elasticsearchexample.builder;

import com.example.elasticsearchexample.model.User;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchQueryBuilder {

    @Autowired
    private ElasticsearchTemplate template;

    public List<User> getAll(String s) {
        QueryBuilder queryBuilder = QueryBuilders.boolQuery().should(
                QueryBuilders.queryStringQuery(s)
                .lenient(true)
                .field("name")
                .field("teamName")
        ).should(QueryBuilders.queryStringQuery("-" + s + "-")
        .lenient(true)
                .field("name")
                .field("teamName"));
        NativeSearchQuery build = new NativeSearchQueryBuilder().withQuery(queryBuilder).build();
        List<User> users = template.queryForList(build, User.class);
        return users;
    }

}
