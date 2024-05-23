package com.example.sprinddatajpa.feature.elastic;

import com.example.sprinddatajpa.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ESRepository extends ElasticsearchRepository<User,String> {
}
