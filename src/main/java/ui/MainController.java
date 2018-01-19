package ui;

import db.Mood;
import db.Problem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebEngine;

public class MainController {
  @FXML private Label hardText;
  @FXML private TextField userInput;
  @FXML private Button submitButton;
  @FXML private ImageView mascot;
  private ControllerFactory factory = new ControllerFactory();
  private InputController input;
  private PromptController prompt;
  private AddMoodController addMood;
  private ResultController result;
  private Problem problem;
  private Mood mood;

  @FXML 
  protected void handleSubmitButtonAction(ActionEvent event) throws Exception {
    mood = TheraPc.manager.checkDatabase(userInput.getText());
    if (mood == null) {
      addMood = (AddMoodController) factory.launch("add");
      addMood.setCommunication(this);
      addMood.setMood(userInput.getText());
      mood = new Mood(userInput.getText());
    } else {
      reactToMood(mood);
    }
  }
  
  /**
   * Depending on the mood, will react accordingly.
   * @param mood Reference to mood
   * @throws Exception for factory
   */
  public void reactToMood(Mood mood) throws Exception {
    if (mood.isNegative()) {
      prompt = (PromptController) factory.launch("prompt");
      prompt.setCommunication(this);
    } else {
      ((GoodController) factory.launch("good"))
        .setText(TheraPc.manager.find(mood.isNegative()).toString());
    }
  }
  
  /**
   * If talkative, will launch into user input. If not, return to main scene.
   * @throws Exception for factory
   */
  public void isTalkative() throws Exception {
    input = (InputController) factory.launch("input");
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

  /**
   * Sets problem to return a result in the Result GUI.
   * @param problem Takes the problem object created by InputController
   */
  public void setProblem(Problem problem) throws Exception {
    String searchInput;
    result = (ResultController) factory.launch("result");
    result.setText(TheraPc.manager.find(mood.isNegative()).toString());
    WebEngine webEngine = result.web.getEngine();
    if (problem != null) {
      searchInput = mood.getKeyword() + "+" + problem.getSearchString();
      webEngine.load("https://duckduckgo.com/?q=" + searchInput);
    } else {
      webEngine.load("http://www.google.com");
    }
  }
  
  public Mood getMood() {
    return mood;
  }
}
