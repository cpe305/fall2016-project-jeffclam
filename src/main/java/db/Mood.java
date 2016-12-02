package db;

public class Mood {
  private String keyword;
  private String category;
  private boolean negative;

  public Mood(String keyword) {
    this.keyword = keyword;
  }

  /**
   * Creates new Mood object with given value and negativity.
   * @param keyword Name of the emotion
   * @param negative Is it a negative emotion or positive emotion?
   */
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

  public void setName(String newKey) {
    this.keyword = newKey;
  }

  @Override
  public String toString() {
    String result = keyword + " is ";
    result += isNegative() ? "negative" : "positive";
    result += "[category: " + category + "]"; 
    return result;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
