package cs3500.shape;

public class PositionMoves extends AbstractMove {

  public PositionMoves(AbstractShape s, Posn position, int tickStart, int tickEnd) {

    if (tickEnd <= tickStart) {
      throw new IllegalArgumentException("The given tickEnd value must be larger than " +
              "the given tickStart value!");
    }

    toActUpon = s;
    this.startTick = startTick;
    this.currentPosition = position;
    this.endTick = endTick;
  }

  protected void changePosition() {
    toActUpon.currentPosition = this.currentPosition;
  }
}
