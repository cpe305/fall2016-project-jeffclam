package logic;

import ui.Mood;

public class MoodAnalyzer {
  /*
   * Signed: Jason Ismail CPE 305 for Jeffrey Lam
   */

  public Mood mood;
  public MusicSelector song;
  public ElasticSearch elasticSearch;
  public CustomSearch customSearch;

  public MoodAnalyzer(Mood mood) {
    this.mood = mood;
  }

  /**
   * Finds a song in the database to match the mood.
   * @param mood reference from constructor
   * @return the result of the search
   */
  public String selectSong(Mood mood) {
    MusicSelector selector = new MusicSelector();
    selector.search(mood.getKeyword());
    return mood.getKeyword();
  }

  /**
   * Finds an answer in the database to match the mood.
   * @param mood reference from constructor
   * @return the result of the search
   */
  public String elasticSearch(Mood mood) {
    elasticSearch = new ElasticSearch();
    elasticSearch.search(mood.getKeyword());
    return mood.getKeyword();
  }

  /**
   * Finds an answer online to match the mood.
   * @param mood reference from constructor
   * @return the result of the search
   */
  public String customSearch(Mood mood) {
    customSearch = new CustomSearch();
    customSearch.search(mood.getKeyword());
    return mood.getKeyword();
  }
}
