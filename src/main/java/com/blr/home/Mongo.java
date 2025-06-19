package com.blr.home;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class Mongo {

    public static void main(String[] args) {
        String connectionString = "mongodb+srv://nitishkumar70:6MUv5hYawijPngyz@cluster0.0n2jif7.mongodb" + ".net" +
                "/?retryWrites=true&w=majority&appName=Cluster0";

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();


        // Create a new client and connect to the server
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                // Access the "Mongo" database
                MongoDatabase database = mongoClient.getDatabase("testMongo");

                // Access the "home" collection
                MongoCollection<Document> collection = database.getCollection("home");

                // Create a new document
                Document newDocument = new Document("name", "John Doe").append("age", 30)
                        .append("city", "New York");

                // Insert the document into the collection
                collection.insertOne(newDocument);

                System.out.println("Document inserted successfully into the 'home' collection!");
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }

    }
}
