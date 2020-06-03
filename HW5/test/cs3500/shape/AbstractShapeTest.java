package cs3500.shape;

import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractShapeTest {

  AbstractShape circle = new Circle("C", new Posn(0, 0), new Posn(25, 25), 255,
0, 0, 50, 50);

  //test that first half of first game line is properly created for Circle
  @Test
  public void testCircleGameSummaryInitial() {
    assertEquals("shape C Circle\n" +
            "motion C 1 0 0 50 50 255 0 0", circle.shapeLog);
  }

}