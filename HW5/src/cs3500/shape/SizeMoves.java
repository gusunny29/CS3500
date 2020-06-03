package cs3500.shape;

public class SizeMoves extends AbstractMove {

  public SizeMoves(AbstractShape s, int newWidth, int newHeight, int tickStart, int tickEnd) {

    if (tickEnd <= tickStart) {
      throw new IllegalArgumentException("The given tickEnd value must be larger than " +
              "the given tickStart value!");
    }

    toActUpon = s;
    this.startTick = tickStart;
    this.endW = newWidth;
    this.endH = newHeight;
    this.endTick = tickEnd;
  }

  protected void changeSize() {
    toActUpon.width = this.endW;
    toActUpon.height = this.endH;
  }
}
