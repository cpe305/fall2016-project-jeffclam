import db.MongoDb;
import ui.Mood;

import java.util.Scanner;

public class Client {
  public static void main(String[] args) {
    MongoDb database = new MongoDb();
    Scanner user_input = new Scanner(System.in);

    String emotion;
    String input;
    boolean negative;
    Mood mood;

    System.out.println("Hello, client!");
    System.out.println("How are you feeling today?");
    System.out.print("I am feeling ");

    // Get user input:

    emotion = user_input.next();

    System.out.println("I've never heard of that before. Is that good or bad?");

    input = user_input.next();
    if (input.equalsIgnoreCase("good")) {
      negative = false;
    } else {
      negative = true;
    }

    // Construct Mood
    mood = new Mood(emotion, negative);
    if (!mood.isNegative()) {
      System.out.println("I'm happy to hear about that!");
    } else {
      System.out.println("I'm sorry to hear about that.");
    }
    // Get user input:
    user_input.close();
    database.addMood(mood);
    database.printMoods();
  }
}
