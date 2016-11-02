package ui;

import db.Mood;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Gui extends Application {

  @Override
  public void start(Stage primaryStage) {
	Mood mood = new Mood("start");
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25, 25, 25, 25));

    //Uploads the face of the mascot
    Mascot doc = new Mascot();
    GridPane.setHalignment(doc.getFace(mood), HPos.CENTER);
    grid.add(doc.getFace(mood), 0, 0);

    Text scenetitle = new Text("Hello, user. How are you feeling today?");
    scenetitle.setFont(Font.font("Calibri", 20));
    GridPane.setHalignment(scenetitle, HPos.CENTER);
    grid.add(scenetitle, 0, 1);

    TextField userInput = new TextField();
    grid.add(userInput, 0, 2);

    Button submitButton = new Button("Submit");
    HBox hbButton = new HBox(10);
    hbButton.setAlignment(Pos.CENTER);
    hbButton.getChildren().add(submitButton);
    GridPane.setHalignment(hbButton, HPos.CENTER);
    grid.add(hbButton, 0, 3);

    // grid.setGridLinesVisible(true);
    Scene scene = new Scene(grid, 800, 600);
    primaryStage.setTitle("TheraPC");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}
