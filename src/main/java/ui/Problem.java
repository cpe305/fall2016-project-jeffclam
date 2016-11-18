package ui;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem {
  private String statement;
  
  public Problem(String statement) {
    this.statement = statement;
  }
  
  public ArrayList<String> getKeywords() {
    ArrayList<String> keywords = new ArrayList<String>(Arrays.asList(statement.split(" ")));
    return keywords;
  }

  public String getStatement() {
    return statement;
  }

  public void setStatement(String statement) {
    this.statement = statement;
  }
  
  /**
   * Goes through the statement and returns the keywords.
   */
  public void printKeywords() {
    for (String k : getKeywords()) {
      System.out.println(k);
    }
  }
}
