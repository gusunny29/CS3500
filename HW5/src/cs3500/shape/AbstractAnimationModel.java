package cs3500.shape;

import java.util.ArrayList;

/**
 * Represents an abstract class for the model interface. Includes fields regarding the shapes for
 * the animation, the speed of the animation, and the currentTick the game is on.
 */

public abstract class AbstractAnimationModel implements AnimationModel {

  //the shapes presently included in this animation
  protected ArrayList<AbstractShape> shapes;

  //represents all the different moves associated with this animation
  protected ArrayList<AbstractMove> moves;

  //the tick speed of this program
  protected int animationSpeed;

  //the current tick this program is on
  protected int currentTick;

  public void changeSpeed(int speed) throws IllegalArgumentException {
    this.animationSpeed = speed;
  }
}
