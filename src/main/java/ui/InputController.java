package ui;

import db.Problem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class InputController extends CustomController {
  @FXML private Button submit;
  @FXML private Button clear;
  @FXML private Button cancel;
  @FXML private TextArea input;
  
  @FXML 
  protected void handleSubmit(ActionEvent event) throws IOException {
    Problem problem = new Problem(input.getText());
    main.setProblem(problem);
    Stage stage = (Stage) submit.getScene().getWindow();
    stage.close();
  }
  
  @FXML 
  protected void handleClear(ActionEvent event) {
    input.clear();
  }
  
  @FXML 
  protected void handleCancel(ActionEvent event) {
    Stage stage = (Stage) cancel.getScene().getWindow();
    stage.close();
  }
}
