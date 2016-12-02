package db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Problem {
  private String statement;
  private ArrayList<String> selfPronouns;
  private ArrayList<String> otherPronouns;
  private ArrayList<String> keywords;
  private TreeMap<String, String> pronouns = 
      new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
  
  public Problem(String statement) {
    this.statement = statement;
    setUpPronouns();
  }
  
  /**
   * Separates keywords and pronouns.
   * @return ArrayList of the keywords.
   */
  public ArrayList<String> getKeywords() {
    keywords = new ArrayList<String>(Arrays.asList(statement.split(" ")));
    for (int i = 0; i < keywords.size(); i++) {
      if (pronouns.get(keywords.get(i)) != null) {
        if (pronouns.get(keywords.get(i)) != "self") {
          selfPronouns.add(keywords.get(i));
          keywords.remove(i);
        }
      }
    }
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
  
  /**
   * Sets up map to have pronouns for references.
   */
  public void setUpPronouns() {
    pronouns.put("i", "self");
    pronouns.put("my", "self");
    pronouns.put("me", "self");
    pronouns.put("mine", "self");
    
    pronouns.put("he", "male other");
    pronouns.put("his", "male other");
    pronouns.put("him", "male other");
    
    pronouns.put("she", "female other");
    pronouns.put("hers", "female other");
    pronouns.put("herself", "female other");
    
    pronouns.put("ze", "nc other");
    pronouns.put("zir", "nc other");
    pronouns.put("zirs", "nc other");
    pronouns.put("zirself", "nc other");
    
    pronouns.put("they", "other");
    pronouns.put("their", "other");
    pronouns.put("themself", "other");
    pronouns.put("themselves", "other");
  }
}
