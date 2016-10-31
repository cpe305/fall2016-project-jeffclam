package db;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDb {
  private MongoClient mongoClient;
  private MongoDatabase db;

  public MongoDb() {
    mongoClient = new MongoClient();
    db = mongoClient.getDatabase("test");
  }

  public void addMood(Mood mood) {
    db.getCollection("moods").insertOne(new Document("mood", new Document()
        .append("name", mood.getKeyword()).append("negative", String.valueOf(mood.isNegative()))));
  }

  /**
   * Checks to see if the mood is in the database.
   * @param mood Mood to be compared
   * @return if found, true
   */
  public boolean find(Mood mood) {
    FindIterable<Document> iterable = db.getCollection("moods")
        .find(new Document("mood", new Document("name", mood.getKeyword())));
    return iterable.first() == null; // Not actually sure if this returns
                                     // null if it cannot find the
                                     // element
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
