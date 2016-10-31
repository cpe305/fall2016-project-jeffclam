package db;

import logic.MoodAnalyzer;

public class Mood {
  /*
   * Signed: Jason Ismail CPE 305 for Jeffrey Lam
   */

  private boolean negative;
  private String keyword;
  public MoodAnalyzer analysis;

  public Mood(String keyword) {
    this.keyword = keyword;
  }

  public Mood(String keyword, boolean negative) {
    this.keyword = keyword;
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
  
  public String getKeyword() {
    return this.keyword;
  }

  public void setKeyword(String newKey) {
    this.keyword = newKey;
  }

}