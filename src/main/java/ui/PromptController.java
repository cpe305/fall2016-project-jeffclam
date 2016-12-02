package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PromptController extends CustomController {
  @FXML private Button yesButton;
  @FXML private Button noButton;
  
  @FXML 
  protected void handleYes(ActionEvent event) throws IOException {
    main.setIsTalkative(true);
    closeWindow();
  }
  
  @FXML 
  protected void handleNo(ActionEvent event) throws IOException {
    main.setIsTalkative(false);
    closeWindow();
  }
  
  public void closeWindow() {
    Stage stage = (Stage) yesButton.getScene().getWindow();
    stage.close();
  }
  
  public PromptController getController() {
    return this;
  }
}
