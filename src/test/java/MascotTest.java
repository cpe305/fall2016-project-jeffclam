import static org.junit.Assert.assertEquals;

import db.Mood;
import org.junit.Test;
import ui.Mascot;

public class MascotTest {

  @Test
  public void testMascot() {
    Mood mood = new Mood("sad", true);
    Mascot mascot = new Mascot(mood);
    
    assertEquals(mood, mascot.getMood());
  }

  @Test
  public void testChooseFace() {
    Mood defaultMood = new Mood("start", false);
    Mascot mascot = new Mascot(defaultMood);
    assertEquals("/rsrc/calm.png", mascot.chooseFace());
    
    Mood sad = new Mood("sad", true);
    mascot.setMood(sad);
    assertEquals("/rsrc/sad.png", mascot.chooseFace());
    
    Mood happy = new Mood("happy", false);
    mascot.setMood(happy);
    assertEquals("/rsrc/happy.png", mascot.chooseFace());
  }
}
