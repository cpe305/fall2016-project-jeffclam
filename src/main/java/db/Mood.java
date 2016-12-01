package db;

import org.mongodb.morphia.annotations.Entity;

@Entity("moods")
public class Mood {
  private String name;
  private boolean negative;

  public Mood(String keyword) {
    this.name = keyword;
  }

  public Mood(String keyword, boolean negative) {
    this.name = keyword;
    this.negative = negative;
  }

  public boolean isNegative() {
    // if negative == true it will return true and vice versa
    return this.negative;
  }
  
  public void setNegative(boolean negative) {
    // if negative == true it will return true and vice versa
    this.negative = negative;
  }
  
  public String getName() {
    return this.name;
  }

  public void setName(String newKey) {
    this.name = newKey;
  }

  @Override
  public String toString() {
    String result = name + " is ";
    result += isNegative() ? "negative" : "positive";
    return result;
  }
}
