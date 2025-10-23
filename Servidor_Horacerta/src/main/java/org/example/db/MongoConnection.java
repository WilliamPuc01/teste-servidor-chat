package org.example.db;

import io.github.cdimascio.dotenv.Dotenv;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {
    private static final Dotenv dotenv = Dotenv.load();
    private static final String uri = dotenv.get("mongodb+srv://william:japa123@meuprimeirocluster.n6uh5ie.mongodb.net/?retryWrites=true&w=majority&appName=MeuPrimeiroCluster");
    private static final String dbName = dotenv.get("sample_horacerta");

    public static MongoDatabase getDatabase() {
        MongoClient client = MongoClients.create(uri);
        return client.getDatabase(dbName);
    }
}
