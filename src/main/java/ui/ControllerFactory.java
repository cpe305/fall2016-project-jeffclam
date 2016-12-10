package ui;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class ControllerFactory {  
  /**
   * Factory for launching controllers.
   * @param type type of controller to make
   * @return controller
   * @throws Exception error in controller
   */
  public CustomController launch(String type) throws Exception {
    switch (type) {
      case "add":
        return launchAddMood();
      case "good":
        return launchGood();
      case "input":
        return launchInput();
      case "prompt":
        return launchPrompt();
      case "result":
        return launchResult();
      default:
        throw new Exception("Not a real type");
        
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
  public ResultController launchResult() throws IOException {
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
}
