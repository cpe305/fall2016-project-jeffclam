package ui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

public class ResultController extends CustomController {
  @FXML private TextField song;
  @FXML WebView web;
  
  public void setText(String text) {
    song.setText(text);
  }
}
