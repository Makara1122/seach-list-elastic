package com.example.sprinddatajpa.feature.elastic;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.example.sprinddatajpa.domain.User;
import com.example.sprinddatajpa.utils.ESUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.function.Supplier;

@Service
public class ELServiceImpl {
    @Autowired
    private ElasticsearchClient elasticsearchClient;

    public SearchResponse<User> autoSuggest(String patialUserName) throws IOException {
        Supplier<Query> supplier = ESUtils.createSupplierAutoSuggest(patialUserName);
        return elasticsearchClient.search(s->s.index("makara-tester-v2").query(supplier.get()),User.class);
    }
}
