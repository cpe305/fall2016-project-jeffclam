public class Mood {
   /* Signed: Jason Ismail
    * CPE 305
    * for Jefferey Lam
    */

   private boolean negative;
   private String keyword;
   public MoodAnalyzer analysis;
   
   public Mood(String keyword) {
      this.keyword = keyword;
   }

   public boolean isNegative() {
      //if negative == true it will return true and vice versa
      return this.negative;
   }

   public String getKeyword() {
      return this.keyword;
   }

   public void setKeyword(String newKey) {
      this.keyword = newKey;
   }


}

