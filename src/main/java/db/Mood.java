package db;

public class Mood extends DbObject {
  private boolean negative;
  private String keyword;

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

  @Override
  public String toString() {
    String result = keyword + " is ";
    result += isNegative() ? "negative" : "positive";
    return result;
  }
}
