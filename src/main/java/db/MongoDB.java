package db;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import userInterface.Mood;

public class MongoDB {
   private MongoClient mongoClient;
   private MongoDatabase db;
   
   public MongoDB() {
      mongoClient = new MongoClient();
      db = mongoClient.getDatabase("moods");
   }
   
   public void addMood(Mood mood) {
      db.getCollection("moods").insertOne(
            new Document("mood",
                  new Document()
                     .append("name", mood.getKeyword())
                     .append("negative", String.valueOf(mood.isNegative()))));
   }
}
