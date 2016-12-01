package ui;

import db.Mood;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {
  @FXML private TextField userInput;
  @FXML private Button submitButton;
  @FXML private ImageView mascot;
  
  @FXML 
  protected void handleSubmitButtonAction(ActionEvent event) {
    Mood mood = TheraPc.checkDatabase(userInput.getText());
    mascot.setImage(new Image(chooseFace(mood),200, 0, true, true));
  }
  
  /**
   * Returns the file location of the correct image to use.
   * @return File location of image
   */
  public String chooseFace(Mood mood) {
    if (mood.isNegative()) {
      return "sad.png";
    } else {
      return "happy.png";
    }
  }
  
}
