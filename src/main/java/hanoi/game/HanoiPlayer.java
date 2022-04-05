/**
 * 
 */
package hanoi.game;

import java.io.PrintWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import hanoi.misc.AccessibleByTest;
import hanoi.model.HanoiTowers;
import hanoi.model.Tower;
import lombok.Getter;

/**
 * This class represents a player solving the Tower of Hanoi puzzle. Since this is not a real human
 * player, the game is always played in an optimal manner with the minimum number of moves.
 * 
 * @author Promineo
 *
 */
@Component
public class HanoiPlayer {
  /*
   * A Writer is set up using the system console so that we can print pretty pictures in Unicode if
   * desired. Actually, it should print just as well using a PrintStream. This illustrates the many
   * design decisions that are made while developing an application. Some are better than others...
   */
  @AccessibleByTest
  PrintWriter printWriter = new PrintWriter(System.out, true);

  /*
   * This keeps track of the number of moves used by the system to solve the puzzle. It works out to
   * 2^n-1 where n is the height of the tower. A getter is provided by Lombok so that a test can be
   * used to see if the algorithm is working correctly. Note that the primitive instance variable is
   * initialized to zero (guaranteed by Java).
   */
  @Getter
  private int numMoves;

  /*
   * The attribute tower.height is read from application.yaml (in src/main/resources). Spring Boot
   * loads application.yaml automatically, and when it encounters @Value in a managed Bean, it
   * injects the value into the annotated variable.
   */
  @Value("${tower.height}")
  @AccessibleByTest
  int towerHeight;

  /* This contains the gameboard with the three towers. */
  private HanoiTowers towers;

  /**
   * Play the game Tower of Hanoi (or solve the puzzle, if you prefer).
   */
  public void playTowerOfHanoi() {
    towers = new HanoiTowers(towerHeight);

    /* Print the tower in the initial state. */
    printWriter.printf("Initial tower with height of %d. Minimum number of moves is %d.%s",
        towerHeight, ((int) Math.pow(2, towerHeight) - 1), System.lineSeparator());

    printGameState();

    /*
     * Make the initial move. This calls a method that calls itself recursively so this is the only
     * move that is required to complete the game.
     */
    prepareMove(towerHeight, towers.getLeft(), towers.getMiddle(), towers.getRight());

    /* Print the number of moves. */
    printWriter.println();
    printWriter.println("Tower moved in " + numMoves + " move(s).");
  }

  /**
   * This prints the state of all three towers as a semi-graphical image.
   */
  private void printGameState() {
    printWriter.println(towers.toString());
  }

  /**
   * This method recursively calls itself (which is kind of the definition of recursion, after all).
   * It works by understanding that there are always three towers. It makes moves on all three
   * towers building up a move stack that is unwound when the move position reaches one.
   * 
   * @param pos The move position. This ranges from 1 to the height of the tower.
   * @param from The tower to move from. Initially this is the left tower but this changes as the
   *        algorithm progresses.
   * @param other An intermediate tower used to temporarily stash the disks.
   * @param to The tower to move to.
   */
  private void prepareMove(int pos, Tower from, Tower other, Tower to) {
    if (pos == 1) {
      performMove(pos, from, to);
    } else {
      prepareMove(pos - 1, from, to, other);
      performMove(pos, from, to);
      prepareMove(pos - 1, other, from, to);
    }
  }

  /**
   * This moves the disk with the given size from the from tower to the to tower.
   * 
   * @param pos The disk to move.
   * @param from The tower to move from.
   * @param to The tower to move to.
   */
  private void performMove(int pos, Tower from, Tower to) {
    to.push(from.pop());

    printWriter.println("\nMoved disc " + pos + " from " + from.getTowerName() + " tower to "
        + to.getTowerName() + " tower.");

    printGameState();
    numMoves++;
  }
}
