package cs3500.shape;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents the implementation of the {@code AnimationModel} interface. Has a field representing
 * all the Shapes currently inside the animation.
 */
public class AnimationModelImpl extends AbstractAnimationModel {

  /**
   * Default constructor for AnimationModelImpl. Creates an animation with no shapes. Speed is set
   * to 10 by default. Current tick is zero.
   */
  public AnimationModelImpl() {
    this(new ArrayList<AbstractShape>(), new ArrayList<AbstractMove>(), 1, 1);
  }

  /**
   * Constructs an AnimationModelImpl. Given shapes with default values of 500 for both width and
   * height. Speed is set to 10 by default. Current tick is zero.
   *
   * @param shapes the Shapes to be animated
   */
  public AnimationModelImpl(ArrayList<AbstractShape> shapes, ArrayList<AbstractMove> moves) {
    this(shapes, moves, 1, 1);
  }

  /**
   * Constructs an AnimationModelImpl. The shapes are set to the given shapes as well as the given
   * height and width. Current tick is zero.
   *
   * @param shapes the Shapes to be animated
   * @throws IllegalArgumentException if given a non-positive width
   * @throws IllegalArgumentException if given a non-positive height
   */
  public AnimationModelImpl(ArrayList<AbstractShape> shapes, ArrayList<AbstractMove> moves,
                            int animationSpeed, int currentTick) throws IllegalArgumentException {

    if (animationSpeed < 0) {
      throw new IllegalArgumentException("Cannot be given a negative animation speed!");
    }

    if (currentTick < 0) {
      throw new IllegalArgumentException("Cannot be given a negative current tick!");
    }

    //check if any of the names occur twice in the ArrayList
    for (int i = 0; i < shapes.size(); i++) {
      int count = 0;
      String current = shapes.get(i).name;

      for (int j = 0; j < shapes.size(); j++) {
        if (shapes.get(j).name.equals(current)) {
          count++;
        }
      }
      if (count > 1) {
        throw new IllegalArgumentException("Cannot be given the same name for any two shapes!");
      }
    }

    this.shapes = shapes;
    this.moves = moves;
    this.animationSpeed = animationSpeed;
    this.currentTick = currentTick;
  }


  @Override
  public ArrayList<AbstractShape> addShape(AbstractShape s, int tick)
          throws IllegalArgumentException {


    this.shapes.add(s);

    ArrayList<AbstractShape> copy = new ArrayList<AbstractShape>();
    copy.addAll(shapes);

    return copy;
  }

  @Override
  public ArrayList<AbstractShape> disappear(AbstractShape s, int tick) {

    shapes.remove(s);

    ArrayList<AbstractShape> copy = new ArrayList<AbstractShape>();
    copy.addAll(shapes);

    return copy;
  }

  @Override
  public void startOver() {
    this.currentTick = 0;
  }

  @Override
  public void pause() {
    //I don't know how to do this
  }

  @Override
  public void resume() {
    //don't know how to do this
  }

  @Override
  public String getTextAnimation() {
    //for each shape in Shapes, print their shape log

    String result = "";

    for (int i = 0; i < shapes.size(); i++) {

      AbstractShape s = shapes.get(i);

      //add the header
      result += "shape " + s.name + " " + s.getClass().getSimpleName() + "\n";
      //add the first half line of the log for the shape
      result += "motion " + s.name + " 1 " + s.currentPosition.getX() + " "
              + s.currentPosition.getY() + " " + s.width + " " + s.height + " " + s.r + " " + s.g
              + " " + s.b + "     ";

      ArrayList<AbstractMove> movesForThisShape = getMovesForThisShape(s);

      int firstMoveTick = firstMove(movesForThisShape);

      //add the second half of the first line for the log to the shape
      result += firstMoveTick + " " + s.currentPosition.getX() + " "
              + s.currentPosition.getY() + " " + s.width + " " + s.height + " " + s.r + " " + s.g
              + " " + s.b;

      //add the rest of the log to the shape
      result += s.shapeLog;

      if (i != shapes.size() - 1) {
        result += "\n\n";
      }
    }
    return result;
  }

  //returns the list of AbstractMove for the given Shape
  private ArrayList<AbstractMove> getMovesForThisShape(AbstractShape s) {
    ArrayList<AbstractMove> movesForGivenShape = new ArrayList<AbstractMove>();
    //for the given shape, cycle through the moves and return the
    // list of all that apply to this move
    for (AbstractMove move : moves) {
      if (move.toActUpon.equals(s)) {
        movesForGivenShape.add(move);
      }
    }
    return movesForGivenShape;
  }

  //returns the integer value for the earliest tick move from the given list of moves
  //return -1 if there are no moves in the given list
  private int firstMove(ArrayList<AbstractMove> givenMoves) {
    int firstMoveTime = -1;
    for (AbstractMove m : givenMoves) {
      if (m.startTick < firstMoveTime || firstMoveTime == -1) {
        firstMoveTime = m.startTick;
      }
    }
    return firstMoveTime;
  }

  private void addMovesToShapeLog() {
    //for every move in this moves, add the move toString method to their shapeLog
    for (int i = 0; i < moves.size(); i++) {
      AbstractMove currentMove = moves.get(i);

      AbstractShape currentShape = currentMove.toActUpon;

      currentShape.shapeLog += currentMove.getMoveSummary();
    }
  }
}
