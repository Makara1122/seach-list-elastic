package com.example.sprinddatajpa.utils;

import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import lombok.val;

import java.util.function.Supplier;

public class ESUtils {

    public static Supplier<Query> createSupplierAutoSuggest(String patialUserName){
        Supplier<Query> query = () -> Query.of(q -> q.match(createAutoSuggestMatchQuery(patialUserName)));
        return query;
    }

    public static MatchQuery createAutoSuggestMatchQuery(String partialUserName) {
        val authoSuggestQuery = new MatchQuery.Builder();


        return authoSuggestQuery.
                field("name").
                query(partialUserName).
                analyzer("standard").
                build();
    }
}
