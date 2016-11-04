package db;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MongoDb {
  private MongoClient mongoClient;
  private MongoDatabase db;

  /**
   * Initializes database.
   */
  public MongoDb() {
    mongoClient = new MongoClient();
    db = mongoClient.getDatabase("test");
    Logger mongoLogger = Logger.getLogger("org.mongodb.driver");;
    mongoLogger.setLevel(Level.SEVERE);
  }

  public void addMood(Mood mood) {
    db.getCollection("moods").insertOne(new Document("mood", new Document()
        .append("name", mood.getKeyword()).append("negative", String.valueOf(mood.isNegative()))));
  }

  /**
   * Checks to see if the mood is in the database.
   * @param emotion Mood to be compared
   * @return if found, true
   */
  public Mood find(String emotion) {
    final Mood mood = new Mood(emotion);
    
    FindIterable<Document> iterable = db.getCollection("moods")
        .find(new Document("mood.name", mood.getKeyword()));
    
    if (iterable.first() == null) {
      return null;
    } else {
      mood.setNegative(Boolean.parseBoolean(
          ((Document) iterable.first().get("mood")).getString("negative")));
    }
    
    return mood;
  }

  /**
   * This method prints all mood documents in collection.
   */
  public void printMoods() {
    FindIterable<Document> iterable = db.getCollection("moods").find();
    iterable.forEach(new Block<Document>() {
      @Override
      public void apply(final Document document) {
        System.out.println(document);
      }
    });
  }
}