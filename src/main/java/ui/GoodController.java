package ui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class GoodController extends CustomController {
  @FXML private TextField song;
  
  public void setText(String text) {
    song.setText(text);
  }
}
