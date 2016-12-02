package db;

import com.mongodb.client.FindIterable;
import org.bson.Document;

public class DbManager {
  final MongoDb database;
  
  /**
   * Setting up database manager for MongoDB objects for easier java compatibility.
   */
  public DbManager() {
    database = new MongoDb();
  }
  
  /**
   * Checks the database for the emotion stated. If non-existent, add it in.
   * @param emotion emotion to compare with moods
   */
  public Mood checkDatabase(String emotion) {
    Mood mood = new Mood(emotion);
    
    mood = find(mood);
    
    if (mood != null) {
      return mood;
    } else {      
      System.out.println("I've never heard of that before.");
      mood = new Mood(emotion, true);
      mood.setCategory("sad");
      add(mood);
      
      return mood;
    }    
  }
  
  /**
   * Add's a new mood into the moods collection.
   * @param mood new mood to add to the database
   */
  public void add(Mood mood) {
    Document document = new Document("mood", mood.getKeyword())
                                  .append("category", mood.getCategory())
                                  .append("negative", mood.isNegative());
    database.getCollection("moods").insertOne(document);
  }
  
  /**
   * Checks to see if the mood is in the database.
   * @param mood Mood to be compared
   * @return if found, true
   */
  public Mood find(Mood mood) {    
    FindIterable<Document> iterable = database.getCollection("moods")
        .find(new Document("mood", mood.getKeyword()));
    
    if (iterable.first() == null) {
      return null;
    } else {
      mood.setCategory(iterable.first().getString("category"));
      mood.setNegative(iterable.first().getBoolean("negative"));
    }
    
    return mood;
  }
}
