package com.dev.elasticsearch_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories  // elasticsearch repositorylerini kullanabilmemizi sağlayacak
public class ElasticsearchDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchDemoApplication.class, args);
	}

}
