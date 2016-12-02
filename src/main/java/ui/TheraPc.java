package ui;

import db.DbManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class TheraPc extends Application {
  static DbManager manager = new DbManager();

  @Override
  public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/MainGUI.fxml"));
    Scene scene = new Scene(root, 800, 600);
    
    stage.setTitle("TheraPC");
    stage.setScene(scene);
    stage.show();
    stage.setOnCloseRequest((new EventHandler<WindowEvent>() {
      @Override
      public void handle(WindowEvent arg0) {
        Platform.exit();
      }
      
    }));
        
  }
  
  /**
   * This is the main for the driver class of my project.
   **/
  public static void main(String[] args) {
    launch(args);
  }
}
