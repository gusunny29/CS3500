package cs3500.shape;

public class ColorMoves extends AbstractMove {

  public ColorMoves(AbstractShape s, int r, int g, int b, int startTick, int endTick) {
    if (endTick <= startTick) {
      throw new IllegalArgumentException("The given tickEnd value must be larger than " +
              "the given tickStart value!");
    }
    toActUpon = s;
    this.startTick = startTick;
    this.endR = r;
    this.endG = g;
    this.endB = b;
    this.endTick = endTick;
  }

  protected void changeColor() {
    toActUpon.r = this.endR;
    toActUpon.g = this.endG;
    toActUpon.b = this.endB;
  }
}
