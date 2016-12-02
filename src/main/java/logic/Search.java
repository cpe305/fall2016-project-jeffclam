package logic;

import db.Problem;

import java.util.ArrayList;

public interface Search {
  void search(Problem problem);
  
  void search(ArrayList<String> keywords);
  
  void getOutput();
}
