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

      result += "shape " + s.name + " " + s.getClass().getSimpleName() + "\n";
      result += s.shapeLog;

      if (i != shapes.size() - 1) {
        result += "\n\n";
      }
    }
    return result;
  }
}
