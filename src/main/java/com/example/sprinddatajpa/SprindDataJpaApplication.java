package com.example.sprinddatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.config.EnableElasticsearchAuditing;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.example.sprinddatajpa.feature.elastic")
@EnableJpaRepositories(basePackages = {
		"com.example.sprinddatajpa.feature.role",
		"com.example.sprinddatajpa.feature.user",
		"com.example.sprinddatajpa.feature.authority"
})
public class SprindDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprindDataJpaApplication.class, args);
	}

}
