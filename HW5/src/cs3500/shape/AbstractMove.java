package cs3500.shape;

/**
 * Represents the different possible moves for a Shape. Can either change color, size or position.
 */
public abstract class AbstractMove {

  protected AbstractShape toActUpon;

  protected int startTick;

  protected Posn currentPosition;

  /*
  protected int startW;

  protected int startH;

  protected int startR;

  protected int startG;

  protected int startB;
   */

  protected int endTick;

  protected Posn currentDestination;

  protected int endW;

  protected int endH;

  protected int endR;

  protected int endG;

  protected int endB;

  //returns the single line summary for the start and end position of this move
  protected String getMoveSummary() {
    String firstHalf = "motion " + toActUpon.name + " " + startTick + " "
            + toActUpon.currentPosition.getX() + " " + toActUpon.currentPosition.getY() + " "
            + toActUpon.width + " " + toActUpon.height + " " + toActUpon.r + " " + toActUpon.g + " "
            + toActUpon.b;

    String secondHalf =  "     " + endTick + " " + toActUpon.currentPosition.getX() + " "
            + toActUpon.currentPosition.getY() + " " + toActUpon.width + " " + toActUpon.height
            + " " + toActUpon.r + " " + toActUpon.g + " " + toActUpon.b + "\n";

    return firstHalf + secondHalf;
  }
}
