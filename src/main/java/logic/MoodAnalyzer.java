package logic;

import db.Mood;

public class MoodAnalyzer {
  private SongSearch songSearch;
  private ElasticSearch elasticSearch;
  private CustomSearch customSearch;

  /**
   * Finds a song in the database to match the mood.
   * @param mood reference from constructor
   * @return the result of the search
   */
  public String selectSong(Mood mood) {
    songSearch = new SongSearch();
    songSearch.search(mood);
    return mood.getName();
  }

  /**
   * Finds an answer in the database to match the mood.
   * @param mood reference from constructor
   * @return the result of the search
   */
  public String elasticSearch(Mood mood) {
    elasticSearch = new ElasticSearch();
    elasticSearch.search(mood);
    return mood.getName();
  }

  /**
   * Finds an answer online to match the mood.
   * @param mood reference from constructor
   * @return the result of the search
   */
  public String customSearch(Mood mood) {
    customSearch = new CustomSearch();
    customSearch.search(mood);
    return mood.getName();
  }
}
