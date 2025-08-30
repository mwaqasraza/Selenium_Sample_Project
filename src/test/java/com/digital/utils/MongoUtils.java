package com.digital.util;

import com.mongodb.client.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MongoUtils {

    static MongoClient mongoClient;
    static MongoDatabase mongoDatabase;

    public static String fetch_Single_Record_From_Any_DB_With_BsonFilters(String mongoClientUriKey, String dbName, String collectionName, Bson filters, Bson sort){
        mongoClient = null;
        mongoClient = MongoClients.create(mongoClientUriKey);
        mongoDatabase = mongoClient.getDatabase(dbName);
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(collectionName);
        Document doc;
        if(sort==null){
            doc =  mongoCollection.find(filters).first();
        }else{
            doc = mongoCollection.find(filters).sort(sort).first();
        }
        mongoClient.close();
        return doc.toJson();
    }

    public static ArrayList<String> fetch_Multiple_Records_From_Any_DB_With_BsonFilters(String mongoClientUriKey, String dbName, String collectionName, Bson filters){
        mongoClient = null;
        mongoClient = MongoClients.create(mongoClientUriKey);
        mongoDatabase = mongoClient.getDatabase(dbName);
        MongoCollection<Document> getMongoCollection = mongoDatabase.getCollection(collectionName);
        FindIterable<Document> docs = getMongoCollection.find(filters);
        ArrayList<Document> listOfDoc = docs.into(new ArrayList<Document>());
        ArrayList<String> records = new ArrayList<>();
        listOfDoc.forEach(doc -> records.add(doc.toJson()));
        mongoClient.close();
        return records;
    }

    public static Integer fetch_Record_Counts_From_Any_DB_With_BsonFilters(String mongoClientUriKey, String dbName, String collectionName, Bson filters){
        mongoClient = null;
        mongoClient = MongoClients.create(mongoClientUriKey);
        mongoDatabase = mongoClient.getDatabase(dbName);
        MongoCollection<Document> getMongoCollection = mongoDatabase.getCollection(collectionName);
        Long recordCount = getMongoCollection.countDocuments(filters);
        mongoClient.close();
        return Integer.parseInt(recordCount.toString());
    }

    public static Bson create_Bson_Filter_With_AND(HashMap<String,Object> bsonFilter){
        List<Bson> filters = new ArrayList<>();
        for(String key: bsonFilter.keySet()){
            Bson filter = Filters.eq(key,bsonFilter.get(key));
            filters.add(filter);
        }
        Bson finalFilter = Filters.and(filters);
        return finalFilter;
    }

    public static Bson create_Bson_Filter_With_OR(HashMap<String,Object> bsonFilter){
        List<Bson> filters = new ArrayList<>();
        for(String key: bsonFilter.keySet()){
            Bson filter = Filters.eq(key,bsonFilter.get(key));
            filters.add(filter);
        }
        Bson finalFilter = Filters.and(filters);
        return finalFilter;
    }
}