package com.mysql.to.mongo.secondary;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(
        basePackages = {"com.mysql.to.mongo.secondary"},
        mongoTemplateRef = "secondaryTemplate"
)
@EnableConfigurationProperties
@EnableTransactionManagement
public class SecondaryDbConfig {

    @Bean(name = "secondaryProperties")
    @ConfigurationProperties(prefix = "mongodb.secondary")
    @Primary
    public MongoProperties secondaryProperties() {
        return new MongoProperties();
    }

    @Bean(name = "secondaryClient")
    public MongoClient mongoClient(@Qualifier("secondaryProperties")MongoProperties mongoProperties) {
        return MongoClients.create(MongoClientSettings.builder()
                .applyToClusterSettings(builder -> builder
                        .hosts(Collections.singletonList(new ServerAddress(mongoProperties.getHost(), mongoProperties.getPort()))))
                .build());
    }

    @Bean(name = "secondaryDbFactory")
    public MongoDatabaseFactory mongoDatabaseFactory(
            @Qualifier("secondaryClient") MongoClient mongoClient,
            @Qualifier("secondaryProperties") MongoProperties mongoProperties) {
        return new SimpleMongoClientDatabaseFactory(mongoClient, mongoProperties.getDatabase());
    }

    @Bean(name = "secondaryTemplate")
    public MongoTemplate mongoTemplate(@Qualifier("secondaryDbFactory") MongoDatabaseFactory mongoDatabaseFactory) {
        return new MongoTemplate(mongoDatabaseFactory);
    }
}