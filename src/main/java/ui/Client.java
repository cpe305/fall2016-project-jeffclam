package ui;

import com.mongodb.MongoException;

import db.MongoDb;
import db.Mood;

import java.util.Scanner;


public class Client {
  /**
   * This is the main for the driver class of my project.
   **/
  public static void main(String[] args) {
    MongoDb database = new MongoDb();
    Scanner userInput = new Scanner(System.in);

    System.out.println("Hello, client!" + '\n' + "How are you feeling today?");
    System.out.print("I am feeling ");

    // Get user input:
    String emotion = userInput.next();
    try {
      checkDatabase(userInput, emotion, database);
    } catch (MongoException connection) {
      System.out.println("No connection");
    }
    // Get user input:
    userInput.close();
  }
  
  /**
   * Checks the database for the emotion stated. If non-existent, add it in.
   * @param userInput scanner for input
   * @param emotion emotion to compare with moods
   * @param database reference to database
   */
  public static void checkDatabase(Scanner userInput, String emotion, MongoDb database) {
    Mood mood = database.find(emotion);
    if (mood != null) {
      if (!mood.isNegative()) {
        System.out.println("I'm happy to hear about that!");
      } else {
        System.out.println("I'm sorry to hear about that.");
      }
    } else {
      // Check in the database if emotion exists, if not:
  
      System.out.println("I've never heard of that before. Is that good or bad?");
      mood = new Mood(emotion);
      if ("good".equalsIgnoreCase(userInput.next())) {
        mood.setNegative(false);
      } else {
        mood.setNegative(true);
      }
      database.addMood(mood);
  
      if (!mood.isNegative()) {
        System.out.println("I'm happy to hear about that!");
      } else {
        System.out.println("I'm sorry to hear about that.");
      }
    }
  }
}
