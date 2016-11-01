package ui;

import db.Mood;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class Mascot {

  /**
   * Sends face image back to the GUI.
   * @return ImageView file to be read by HBox in GUI
   */
  public HBox getFace() {
    final HBox pictureRegion = new HBox();
    pictureRegion.getChildren().add(updateFace());
    pictureRegion.setAlignment(Pos.CENTER);
    return pictureRegion;
  }
  
  /**
   * Reads in the emotion and changes the face of the mascot accordingly. 
   * @return ImageView object of Image of mascot
   */
  public ImageView updateFace() {
    String faceFile = chooseFace();
    
    final ImageView imv = new ImageView();
    final Image image = new Image(faceFile, 200, 0, true, true);
    imv.setImage(image);    
    return imv;
  }
  
  public String chooseFace(Mood mood) {
    if (mood.isNegative()) {
	  return "/rsrc/sad.png";
	}
    return "/rsrc/calm.png";
  }
}
