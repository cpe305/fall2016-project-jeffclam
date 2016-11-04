package ui;

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
    Mood mood = new Mood(emotion);
    if (database.find(mood)) {
      if (!mood.isNegative()) {
        System.out.println("I'm happy to hear about that!");
      } else {
        System.out.println("I'm sorry to hear about that.");
      }
    } else {
      // Check in the database if emotion exists, if not:

      System.out.println("I've never heard of that before. Is that good or bad?");

      if ("good".equalsIgnoreCase(userInput.next())) {
        mood.setNegative(false);
      } else {
        mood.setNegative(true);
      }

      if (!mood.isNegative()) {
        System.out.println("I'm happy to hear about that!");
      } else {
        System.out.println("I'm sorry to hear about that.");
      }
    }
    // Get user input:
    userInput.close();
    database.addMood(mood);
    database.printMoods();
  }
}
