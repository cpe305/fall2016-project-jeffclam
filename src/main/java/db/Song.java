package db;

public class Song {
  private String artist;
  private String songName;
  private boolean isNegative;
  
  public Song(String artist, String songName) {
    this.artist = artist;
    this.songName = songName;
  }
  
  public String getArtist() {
    return artist;
  }
  
  public void setArtist(String artist) {
    this.artist = artist;
  }
  
  public String getSongName() {
    return songName;
  }
  
  public void setSongName(String songName) {
    this.songName = songName;
  }
  
  @Override
  public String toString() {
    return artist + " - " + songName;
  }

  public boolean isNegative() {
    return isNegative;
  }

  public void setNegative(boolean isNegative) {
    this.isNegative = isNegative;
  }
}
