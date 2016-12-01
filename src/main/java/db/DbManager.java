package db;

import com.mongodb.MongoClient;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

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
}
