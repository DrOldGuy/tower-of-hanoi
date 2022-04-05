/**
 * 
 */
package hanoi.model;

import lombok.Value;

/**
 * This class represents a disk on a tower. Each disk "knows" how to print its image. A disk prints
 * something like this: " ▄▄▄▄▄ ". The correct padding is determined by the height of the tower.
 * 
 * @author Promineo
 *
 */
@Value
public class Disk {
  private static final String DISK_CHAR = "▄";

  /* This is the disk image as described in the class comment. It is created in the constructor. */
  private String diskImage;

  /**
   * Create the disk image when the disk is created.
   * 
   * @param sizeOfDisk The width of the disk. Disks need to be centered horizontally so that the
   *        tower printed at the top won't look funny. Therefore, each disk consists of an odd
   *        number of image characters, along with the appropriate padding. A disk of size 1 will
   *        have a single disk character, a disk of size 2 will have 3 disk characters, size 3 will
   *        have 5 disk characters, etc. This leads to a tower of disks looking like this (at the
   *        start of the game):
   * 
   *        <pre>
   *          ▄
   *         ▄▄▄
   *        ▄▄▄▄▄
   *        </pre>
   * 
   * @param towerHeight The height of the tower. This is used to determine the correct padding
   *        around each disk.
   */
  public Disk(int sizeOfDisk, int towerHeight) {
    int imageLength = (sizeOfDisk - 1) * 2 + 1;
    int maxLength = (towerHeight - 1) * 2 + 1;
    String padding = " ".repeat((maxLength - imageLength) / 2);
    String disk = DISK_CHAR.repeat(imageLength);

    diskImage = padding + disk + padding;
  }

  /**
   * This returns the disk image so that the disk can be printed like this:
   * 
   * <pre>
   * printWriter.print(disk);
   * </pre>
   */
  @Override
  public String toString() {
    return diskImage;
  }
}
