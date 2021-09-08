package com.asdf.JavaProject.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.internal.MongoClientImpl;
import org.springframework.data.mongodb.SpringDataMongoDB;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

public class MongoConfig extends AbstractMongoClientConfiguration {
    @Override
    protected String getDatabaseName() {
        return "project-flow";
    }

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb+srv://hong:hong@project-flow.fyczq.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
    }
}
