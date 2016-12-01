package db;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.List;

public class DbManager {
  final Morphia morphia = new Morphia();
  final Datastore datastore;
  
  /**
   * Setting up database manager for MongoDB objects for easier java compatibility.
   * @param mc reference to existing running client
   */
  public DbManager(MongoClient mc) {
    morphia.mapPackage("com.db");
    datastore = morphia.createDatastore(mc, "theradb");
    datastore.ensureIndexes();
  }
  
  public void saveMood(Mood mood) {
    datastore.save(mood);
  }
  
  /**
   * Checks if mood is in the database and returns it.
   * @param mood Mood to find in database.
   * @return If not in database, return null.
   */
  public Mood find(Mood mood) {
    List<Mood> moods = datastore.createQuery(Mood.class)
                              .search(mood.getName())
                              .order("_id")
                              .asList();
    if (moods.isEmpty()) {
      return null;
    } else {
      return moods.get(0);
    }
      
  }
}
