package logic;

import db.Problem;

import java.util.ArrayList;

public class MoodAnalyzer {
  private SongSearch songSearch;
  private ElasticSearch elasticSearch;
  private CustomSearch customSearch;

  /**
   * Finds a song in the database to match the mood.
   * @param problem reference from constructor
   * @return the result of the search
   */
  public ArrayList<String> selectSong(Problem problem) {
    songSearch = new SongSearch();
    songSearch.search(problem);
    return problem.getKeywords();
  }

  /**
   * Finds an answer in the database to match the mood.
   * @param problem reference from constructor
   * @return the result of the search
   */
  public ArrayList<String> elasticSearch(Problem problem) {
    elasticSearch = new ElasticSearch();
    elasticSearch.search(problem);
    return problem.getKeywords();
  }

  /**
   * Finds an answer online to match the mood.
   * @param problem reference from constructor
   * @return the result of the search
   */
  public ArrayList<String> customSearch(Problem problem) {
    customSearch = new CustomSearch();
    customSearch.search(problem);
    return problem.getKeywords();
  }
}
