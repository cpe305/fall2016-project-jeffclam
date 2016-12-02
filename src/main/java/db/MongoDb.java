package db;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;

import org.bson.Document;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MongoDb {
  private MongoClient mongoClient;
  private MongoDatabase db;
  Logger mongoLogger;

  /**
   * Initializes database.
   */
  public MongoDb() {
    mongoClient = new MongoClient(
        new MongoClientURI("mongodb://admin:admin@ds157187.mlab.com:57187/theradb"));
    db = mongoClient.getDatabase("theradb");
    mongoLogger = Logger.getLogger("org.mongodb.driver");
    mongoLogger.setLevel(Level.SEVERE);    
    db.getCollection("moods").createIndex(Indexes.text("mood"));
  }

  public MongoClient getMongoClient() {
    return mongoClient;
  }

  public void setMongoClient(MongoClient mongoClient) {
    this.mongoClient = mongoClient;
  }
  
  public MongoCollection<Document> getCollection(String collection) {
    return db.getCollection(collection);
  }
}