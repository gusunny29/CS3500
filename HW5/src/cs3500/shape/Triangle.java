package cs3500.shape;

public class Triangle extends AbstractShape {
  /**
   * Constructs a {@code Shape} object. All values are specified to be the same as the given ones.
   *
   * @param name               the name of this Shape
   * @param width
   * @param height
   * @param currentPosition    the current position of the shape
   * @param currentDestination the position this shape is headed to
   * @param r                  the redness of the Shape
   * @param g                  the greenness of the Shape
   * @param b                  the blueness of the Shape
   * @throws IllegalArgumentException if the given width or height is non-positive
   * @throws IllegalArgumentException if given r g b values are either greater than 255, less than 0,
   *                                  or do not add up to 255
   * @throws IllegalArgumentException if the given currentPosition or currentDestination have fields
   *                                  that are negative
   */

  public Triangle(String name, Posn currentPosition, Posn currentDestination, int r, int g, int b,
                 int width, int height) {
    //checks to make sure the inputs are valid
    checkConstructorExceptions(width, height, r, g, b, currentPosition, currentDestination);

    name = name;

    this.currentPosition = currentPosition;

    this.currentDestination = currentDestination;

    this.r = r;

    this.g = g;

    this.b = b;

    this.width = width;

    this.height = height;

    this.shapeLog = "shape " + name + " " + this.getClass().getSimpleName() + "\n" + "motion "
            + name + " 1 " + currentPosition.getX() + " " + currentPosition.getY() + " " + width
            + " " + height + " " + r + " " + g + " " + b;
  }
}
