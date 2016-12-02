package ui;

import db.Mood;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
  @FXML private Label hardText;
  @FXML private TextField userInput;
  @FXML private Button submitButton;
  @FXML private ImageView mascot;
  private boolean isTalkative;
  private PromptController prompt;
  private ResultController result;
  
  @FXML 
  protected void handleSubmitButtonAction(ActionEvent event) throws IOException {
    Mood mood = TheraPc.manager.checkDatabase(userInput.getText());
    mascot.setImage(new Image(chooseFace(mood),200, 0, true, true));
    hardText.setText(chooseResponse(mood));
    prompt = launchPrompt();
    prompt.setCommunication(this);
  }
  
  /**
   * Launches the prompt to ask "Would you like to tell me about it?".
   * @return instance of the controller
   * @throws IOException For loading fxml.
   */
  public PromptController launchPrompt() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Prompt.fxml"));
    Parent root = loader.load();
    PromptController controller = loader.<PromptController>getController();
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 400, 280));
    stage.show();
    
    return controller;
  }
  
  /**
   * Launches instance of user input.
   * @return instance of the controller.
   * @throws IOException Exception for loading fxml.
   */
  public InputController launchInput() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Input.fxml"));
    Parent root = loader.load();
    InputController controller = loader.<InputController>getController();
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 540, 380));
    stage.show();
    
    return controller;
  }
  
  /**
   * Launches instance of results.
   * @return instance of the controller.
   * @throws IOException Exception for loading fxml.
   */
  public ResultController launchResult() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Result.fxml"));
    Parent root = loader.load();
    ResultController controller = loader.<ResultController>getController();
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 800, 600));
    stage.show();
    
    return controller;
  }
  
  public boolean getIsTalkative() {
    return isTalkative;
  }
  
  /**
   * If talkative, will launch into user input. If not, return to main scene.
   * @param isTalkative Whether user is willing to talk or not.
   * @throws IOException Throws for fxml load fail.
   */
  public void setIsTalkative(boolean isTalkative) throws IOException {
    this.isTalkative = isTalkative;
    InputController input = null;
    if (isTalkative) {
      input = launchInput();
    }
    if (input != null) {
      input.setCommunication(this);
    }
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
  
  /**
   * Changes text accordingly to what the user inputs.
   * @param mood What to reference to response.
   * @return Appropriate response.
   */
  public String chooseResponse(Mood mood) {
    if (mood.isNegative()) {
      return "I'm sorry to hear about that. Tell me about it.";
    } else {
      return "I'm glad to hear that! Anything I can help with?";
    }
  }
  
}
