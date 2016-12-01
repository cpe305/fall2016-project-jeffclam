package ui;

import db.DbManager;
import db.MongoDb;
import db.Mood;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TheraPc extends Application {
  static MongoDb database = new MongoDb();
  static DbManager manager = new DbManager(database.getMongoClient());

  @Override
  public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));
    Scene scene = new Scene(root, 800, 600);
    
    stage.setTitle("TheraPC");
    stage.setScene(scene);
    stage.show();
  }
  
  /**
   * This is the main for the driver class of my project.
   **/
  public static void main(String[] args) {
    launch(args);
  }

  /**
   * Checks the database for the emotion stated. If non-existent, add it in.
   * @param emotion emotion to compare with moods
   */
  public static Mood checkDatabase(String emotion) {
    Mood mood = database.find(emotion);
    if (mood != null) {
      return mood;
    } else {      
      System.out.println("I've never heard of that before.");
      
      mood = new Mood(emotion);
      mood.setNegative(true);
      manager.saveMood(mood);
      
      return mood;
    }    
  }
  
  public static void addToDatabase(Mood mood) {
    
  }
  
}
