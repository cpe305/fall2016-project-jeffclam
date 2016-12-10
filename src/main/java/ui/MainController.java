package ui;

import db.Mood;
import db.Problem;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class MainController {
  @FXML private Label hardText;
  @FXML private TextField userInput;
  @FXML private Button submitButton;
  @FXML private ImageView mascot;
  private InputController input;
  private PromptController prompt;
  private AddMoodController addMood;
  private Problem problem;
  
  @FXML 
  protected void handleSubmitButtonAction(ActionEvent event) throws IOException {
    Mood mood = TheraPc.manager.checkDatabase(userInput.getText());
    if (mood == null) {
      addMood = launchAddMood();
      addMood.setCommunication(this);
      addMood.setMood(userInput.getText());
    } else {
      reactToMood(mood);
    }
  }
  
  /**
   * Depending on the mood, will react accordingly.
   * @param mood Reference to mood
   * @throws IOException exception for reading file.
   */
  public void reactToMood(Mood mood) throws IOException {
    if (mood.isNegative()) {
      prompt = launchPrompt();
      prompt.setCommunication(this);
    } else {
      launchGood();
    }
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
  public ResultController launchResult(Problem problem) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Result.fxml"));
    Parent root = loader.load();
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 800, 600));
    stage.show();
    stage.setOnCloseRequest((new EventHandler<WindowEvent>() {
      @Override
      public void handle(WindowEvent arg0) {
        Platform.exit();
      }
      
    }));
    return loader.<ResultController>getController();
  }
  
  /**
   * Launches new prompt to add new mood into database.
   * @return instance of controller.
   * @throws IOException error in loading fxml.
   */
  public AddMoodController launchAddMood() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/AddMood.fxml"));
    Parent root = loader.load();
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 400, 280));
    stage.show();
    return loader.<AddMoodController>getController();
  }
  
  /**
   * Launches new prompt for good mood.
   * @return instance of controller
   * @throws IOException exception for loading fxml file.
   */
  public GoodController launchGood() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Good.fxml"));
    Parent root = loader.load();
    Stage stage = new Stage();
    stage.setScene(new Scene(root, 800, 600));
    stage.show();
    stage.setOnCloseRequest((new EventHandler<WindowEvent>() {
      @Override
      public void handle(WindowEvent arg0) {
        Platform.exit();
      }
      
    }));
    return loader.<GoodController>getController();
  }
  
  /**
   * If talkative, will launch into user input. If not, return to main scene.
   * @throws IOException Throws for fxml load fail.
   */
  public void isTalkative() throws IOException {
    input = launchInput();
    input.setCommunication(this);
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

  public Problem getProblem() {
    return problem;
  }

  public void setProblem(Problem problem) throws IOException {
    launchResult(problem);
  }
  
}
