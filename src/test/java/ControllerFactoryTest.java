import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ui.AddMoodController;
import ui.ControllerFactory;
import ui.GoodController;
import ui.InputController;
import ui.PromptController;
import ui.ResultController;

public class ControllerFactoryTest {
  ControllerFactory test = new ControllerFactory();
  
  @Test
  public void testLaunch() throws Exception {
    assertEquals(test.launchAddMood().getClass(), AddMoodController.class);
    assertEquals(test.launchInput().getClass(), InputController.class);
    assertEquals(test.launchGood().getClass(), GoodController.class);
    assertEquals(test.launchResult().getClass(), ResultController.class);
    assertEquals(test.launchPrompt().getClass(), PromptController.class);

  }
}
