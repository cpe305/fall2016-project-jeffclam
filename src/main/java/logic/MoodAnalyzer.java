package logic;
import userInterface.Mood;

public class MoodAnalyzer {
   /* Signed: Jason Ismail
    * CPE 305
    * for Jeffrey Lam
    */

   public Mood mood;
   public MusicSelector song;
   public ElasticSearch eSearch;
   public CustomSearch cSearch;

   public MoodAnalyzer(Mood mood) {
      this.mood = mood;
   }

   public String selectSong(Mood mood) {
      MusicSelector selector = new MusicSelector();
      selector.search(mood.getKeyword());
      return mood.getKeyword();
   }

   public String elasticSearch(Mood mood) {
      ElasticSearch eSearch = new ElasticSearch();
      eSearch.search(mood.getKeyword());
      return mood.getKeyword();
   }

   public String customSearch(Mood mood) {
      CustomSearch cSearch = new CustomSearch();
      cSearch.search(mood.getKeyword());
      return mood.getKeyword();
   }
}
