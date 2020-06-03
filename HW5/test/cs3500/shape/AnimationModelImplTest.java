package cs3500.shape;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class AnimationModelImplTest {

  AbstractShape circle = new Circle("C", new Posn(0, 0), new Posn(25, 25), 255,
          0, 0, 50, 50);


  AbstractMove changeToBlue = new ColorMoves(circle, 0, 0, 255, 10, 50);


  //EXAMPLES OF ANIMATION MODELS
  AnimationModel justCircle = new AnimationModelImpl(
          new ArrayList<AbstractShape>(Arrays.asList(circle)), new ArrayList<AbstractMove>());


  AnimationModel circleChangeColor = new AnimationModelImpl(
          new ArrayList<AbstractShape>(Arrays.asList(circle)),
          new ArrayList<AbstractMove>(Arrays.asList(changeToBlue)));



  //test that justCircle getTextSummary works properly initially
  @Test
  public void justCircleTextSummary() {
    assertEquals("shape C Circle\n" +
            "motion C 1 0 0 50 50 255 0 0     -1 0 0 50 50 255 0 0", justCircle.getTextAnimation());
  }

  //test the circleChangeColor getTextSummary works
  @Test
  public void testCircleChangeColorTextSummary() {
    assertEquals("shape C Circle\n" +
            "motion C 1 0 0 50 50 255 0 0     10 0 0 50 50 255 0 0",
            circleChangeColor.getTextAnimation());
  }
}
