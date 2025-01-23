package com.dev.elasticsearch_demo.repository;

import com.dev.elasticsearch_demo.model.User;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User, String> {

    @Query("{\"match\": {\"name\": {\"query\": \"?0\"}}}")
    List<User> findSearchQuary(String search);

    List<User> findUsersByNameLike(String search);

}
