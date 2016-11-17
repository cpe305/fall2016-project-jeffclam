import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ui.Problem;

import java.util.ArrayList;

public class ProblemTest {

  @Test
  public void testProblem() {
    assertEquals("testing this", (new Problem("testing this")).getStatement());
  }

  @Test
  public void testGetKeywords() {
    Problem problem = new Problem("testing this");
    ArrayList<String> test = new ArrayList<String>();
    test.add("testing");
    test.add("this");
    assertEquals(test, problem.getKeywords());
  }

}
