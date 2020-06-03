package cs3500.shape;
import java.util.ArrayList;

/**
 * Represents the model portion of the animation. Allows for mutating the speed, width/height,
 * shapes present in the game, outputting Animation as a String, etc. INVARIANTS: the speed of the
 * animation is always positive, the x and y coordinates of the Posn of any Shape are non-negative
 */
public interface AnimationModel {

  /**
   * Allows one to mutate the speed of the game here. Higher value for speed results in a faster
   * game. Belongs in the model because it takes care of a specific detail of the actual gameplay.
   *
   * @param speed     the new speed of the animation for the game
   * @throws IllegalArgumentException if given a non-positive value for speed
   */
  void changeSpeed(int speed);

  /**
   * Adds a new Shape to the existing animation at the given location. Belongs in the model because
   * it takes care of a specific detail of the actual gameplay.
   *
   * @param s    the given Shape to be added to the animation
   * @param tick the time when the given Shape will be added to the animatoin
   * @return the updated ArrayList<Shape> for the animation
   * @throws IllegalArgumentException if given null for the Shape
   * @throws IllegalArgumentException if the Shape now overlaps with another Shape
   * @throws IllegalArgumentException if given a negative value for tick
   */
  ArrayList<AbstractShape> addShape(AbstractShape s, int tick) throws IllegalArgumentException;

  /**
   * Removes the given shape from the animation. Rest of animation remains as is.
   *
   * @param s    the Shape to be removed from the animation
   * @param tick represents the time at which this action occurs
   * @return the updated ArrayList<Shape> for the animation
   * @throws IllegalArgumentException if given a Shape that does not already exist in this
   *                                  Animation
   * @throws IllegalArgumentException if given null for the Shape
   * @throws IllegalArgumentException if the Shape now overlaps with another Shape
   */
  ArrayList<AbstractShape> disappear(AbstractShape s, int tick);

  /**
   * Starts the animation over again at the beginning. Sets currentTick to be equal to zero.
   */
  void startOver();

  /**
   * Pauses the animation at its current state. Keeps the current tick at whatever it was.
   */
  void pause();

  /**
   * Resumes the animation at the state it was paused it. Beings to increment current tick again.
   */
  void resume();

  /**
   * Outputs the animation of all the Shapes as a String. Includes pertinent information regarding
   * the tick rate, the x and y location of the Shape, and the RGB values of the Shape. Belongs in
   * the model because it takes care of a specific detail of the actual gameplay.
   *
   * @return the String representation of all the different components of the animation at the start
   * and end
   */
  String getTextAnimation();
}
