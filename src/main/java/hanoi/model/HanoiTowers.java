/**
 * 
 */
package hanoi.model;

import lombok.Getter;

/**
 * The {@link HanoiTowers} class creates the three towers and {@link #toString() returns} the tower
 * images when requested.
 * 
 * @author Promineo
 *
 */
public class HanoiTowers {
  /*
   * These variables contain the three towers. They could easily be created as an array of Tower,
   * but since the number of towers never varies, this lets us identify each tower by name (i.e.,
   * left instead of tower[0]).
   */
  @Getter
  private Tower left;

  @Getter
  private Tower middle;

  @Getter
  private Tower right;

  /* The height of the towers. */
  private int towerHeight;

  /**
   * Create the three game towers (rods).
   * 
   * @param height The height of the towers.
   */
  public HanoiTowers(int height) {
    /* Create the three towers with the height read from application.yaml. */
    left = new Tower("left", height);
    middle = new Tower("middle", height);
    right = new Tower("right", height);

    this.towerHeight = height;

    /*
     * Create all the disks on the left tower. Disks are created so that the largest disk is on the
     * bottom and the smallest is on the top. The for loop runs backwards from tower height --> 1,
     * so the largest disk is created first. It is pushed onto the left tower stack so that it is on
     * the bottom of the stack. The other disks are then created smaller and smaller and pushed onto
     * the stack in order.
     */
    for (int i = height; i > 0; i--) {
      left.push(new Disk(i, height));
    }
  }

  /**
   * This returns an image of all three towers in the current state. The returned String looks
   * something like this:
   * <pre><code>
   * ‖       ‖       ‖     
   * ‖       ▄       ‖     
   * ‖      ▄▄▄    ▄▄▄▄▄   
   * </code></pre>
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    String padding = "   ";

    for (int row = towerHeight - 1; row >= 0; row--) {
      builder.append(left.toString(row)).append(padding);
      builder.append(middle.toString(row)).append(padding);
      builder.append(right.toString(row)).append(System.lineSeparator());
    }

    return builder.toString();
  }
}
