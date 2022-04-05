/**
 * 
 */
package hanoi.model;

import java.util.Stack;
import lombok.Getter;

/**
 * This class represents a tower (or rod) that can hold disks. A tower extends Stack<Disk>, which
 * gives LIFO capabilities to the tower. A disk can be moved from one tower (tower1) to another
 * (tower2) by doing this:
 * 
 * <pre>
 * tower1.push(tower2.pop()).
 * </pre>
 * 
 * @author Promineo
 *
 */
@SuppressWarnings("serial")
public class Tower extends Stack<Disk> {
  /* This character represents a tower with no disk in the requested position. */
  private static final String TOWER_CHAR = "‖";

  /*
   * Each tower has a name (i.e., "left", "middle", etc.). Lombok's @Getter annotation creates the
   * method getTowerName().
   */
  @Getter
  private String towerName;

  /*
   * This contains a String that is printed on the console to represent a tower or rod with no disk.
   * Disks provide their own image. The tower and disk images are all the padded to the same width
   * based on the height of the tower.
   */
  private String towerImage;

  /**
   * The Tower is created with a name (i.e., "right") and a height. All towers must be the same
   * height or weird things will happen.
   * 
   * @param towerName The name of the tower.
   * @param towerHeight The height of the tower.
   */
  public Tower(String towerName, int towerHeight) {
    this.towerName = towerName;

    /* Create a tower image based on the height. It will look something like this: "   ‖   ". */
    String padding = " ".repeat(towerHeight - 1);
    towerImage = padding + TOWER_CHAR + padding;
  }

  /**
   * Returns the correct disk or tower image at the requested row. If the requested row is greater
   * than the number of disks on the tower, the tower image is returned, otherwise the disk is
   * returned.
   * 
   * @param row The row to return. If there is a disk on the row, the disk image is returned.
   *        Otherwise, the tower image is returned.
   */
  public String toString(int row) {

    if (row < this.size()) {
      return this.get(row).toString();
    } else {
      return towerImage;
    }
  }
}
