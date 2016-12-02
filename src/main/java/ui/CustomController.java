package ui;

public abstract class CustomController {
  MainController main;
  
  public CustomController getController() {
    return this;
  }
  
  public void setCommunication(MainController main) {
    this.main = main;
  }
}
