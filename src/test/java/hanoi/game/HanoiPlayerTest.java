/**
 * 
 */
package hanoi.game;

import static org.assertj.core.api.Assertions.assertThat;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.junit.jupiter.api.Test;

/**
 * This class tests the Tower of Hanoi game algorithm.
 * 
 * @author Promineo
 *
 */
class HanoiPlayerTest {

  /**
   * Test that the disks on a tower of a given height is moved from left to right using the minimum
   * number of moves. The expected number of moves is 2^n-1. In the test the PrintWriter is
   * redirected to a StringWriter so that nothing is printed to the console during the test.
   */
  @Test
  void testThatATowerOfAGivenHeightUsesTheCorrectNumberOfMoves() {
    // Given: a tower height
    int towerHeight = 4;
    StringWriter stringWriter = new StringWriter();

    HanoiPlayer player = new HanoiPlayer();
    player.towerHeight = towerHeight;
    player.printWriter = new PrintWriter(stringWriter);

    // When: the tower is built and the disks are moved
    player.playTowerOfHanoi();

    // Then: the number of moves is correct (2^n-1).
    assertThat(player.getNumMoves()).isEqualTo((int) Math.pow(2, towerHeight) - 1);
    assertThat(stringWriter.toString()).isNotEmpty();
  }

}
