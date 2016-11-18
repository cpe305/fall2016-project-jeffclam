package logic;

import java.util.ArrayList;

public interface Search {
  void search(String keyword);
  
  void search(ArrayList<String> keywords);
  
  void getOutput();
}
