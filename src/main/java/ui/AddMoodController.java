package ui;

import db.Mood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AddMoodController extends CustomController {
  @FXML private Button goodButton;
  @FXML private Button badButton;
  @FXML private Label output;
  private Mood mood;
  
  @FXML 
  protected void handleGood(ActionEvent event) throws Exception {
    mood.setNegative(false);
    TheraPc.manager.add(mood);
    main.reactToMood(mood);
    closeWindow();
  }
  
  @FXML 
  protected void handleBad(ActionEvent event) throws Exception {
    mood.setNegative(true);
    TheraPc.manager.add(mood);
    main.reactToMood(mood);
    closeWindow();
  }
  
  public void closeWindow() {
    Stage stage = (Stage) goodButton.getScene().getWindow();
    stage.close();
  }
  
  public void setMood(String text) {
    mood = new Mood(text);
  }
}
