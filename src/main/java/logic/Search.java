package logic;

import db.Mood;

import java.util.ArrayList;

public interface Search {
  void search(Mood mood);
  
  void search(ArrayList<String> keywords);
  
  void getOutput();
}
