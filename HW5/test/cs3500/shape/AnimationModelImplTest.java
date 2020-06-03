package cs3500.shape;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class AnimationModelImplTest {

  AnimationModel justCircle = new AnimationModelImpl(
          new ArrayList<AbstractShape>(Arrays.asList(new Circle("C", new Posn(0, 0), new Posn(25, 25), 255,
                  0, 0, 50, 50))), new ArrayList<AbstractMove>());

  //test that justCircle getTextSummary works properly initially
  @Test
  public void justCircleTextSummary() {
    assertEquals("shape C Circle\n"
        + "motion C 1 0 0 50 50 255 0 0", justCircle.getTextAnimation());
  }


}