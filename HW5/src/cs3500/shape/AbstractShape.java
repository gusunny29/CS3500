package cs3500.shape;


/**
 * Represents a Shape. Shapes contain number of sides, integer values for location, and angle of
 * direction.
 */
public abstract class AbstractShape implements Shape {

  //represents the number of sides for this shape, cannot be changed once instantiated
  protected String name;

  //the width of the shape
  protected int width;

  //the height of the shape
  protected int height;

  //represents the current position of this shape
  //(located at average of width and height for this shape)
  protected Posn currentPosition;

  //represents the destination position of this shape
  //(located at average of width and height for this shape)
  protected Posn currentDestination;

  //represents the redness of the shape
  protected int r;

  //represents the greenness of the shape
  protected int g;

  //represents the blueness of the shape
  protected int b;

  //represents the log of this shape so far for this animation
  protected String shapeLog;

  //throws an exception if any of the given parameters are not valid
  protected void checkConstructorExceptions(int width, int height, int r, int g, int b,
                                            Posn currentPosition, Posn currentDestination) throws IllegalArgumentException {

    //throw exception if given colors are not valid
    areColorsValid(r, g, b);

    //throw exception if given width/height are not valid
    areDimensionsValid(width, height);

    //throw exception if either of the given positions have fields that are negative
    arePosnsValid(currentPosition, currentDestination);
  }

  //throw exception if either of the given positions have fields that are negative
  protected void arePosnsValid(Posn currentPosition, Posn currentDestination) {
    if (currentPosition.getX() < 0 || currentPosition.getY() < 0 ||
            currentDestination.getX() < 0 || currentDestination.getY() < 0) {
      throw new IllegalArgumentException("At least one of the given Posns have a " +
              "negative field value!");
    }
  }

  //throws an exception if the given colors are invalid
  protected void areColorsValid(int r, int g, int b) {
    if (r < 0 ||  r > 255 || g < 0 ||  g > 255 ||  b < 0 ||  b > 255 || r + g + b != 255) {
      throw new IllegalArgumentException("The int values for color must be " +
              "between 0 and 255 inclusive!");
    }
  }

  //a method that throws an exception if either the given width is wider than the screen
  //or the given height is taller than the screen
  protected void areDimensionsValid(int w, int h) {
    if (w < 0 || h < 0 ) {
      throw new IllegalArgumentException("The height and/or width of this Shape must be positive!");
    }
  }

}
