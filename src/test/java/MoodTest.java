import static org.junit.Assert.assertEquals;

import db.Mood;

import org.junit.Test;

public class MoodTest {

  @Test
  public void testMoodStringBoolean() {
    Mood mood = new Mood("test", false);
    assertEquals("test", mood.getName());
    assertEquals(false, mood.isNegative());
  }

}
