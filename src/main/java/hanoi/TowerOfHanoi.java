/**
 * 
 */
package hanoi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import hanoi.game.HanoiPlayer;

/**
 * This class implements the Tower of Hanoi game using recursion. The game has some simple rules.
 * There are three towers: left, middle and right. There is an arbitrary number of disks (read from
 * application.yaml), all with different sizes. Initially, all the disks are stacked on the left rod
 * from largest on the bottom to smallest on the top. The game is won when all disks are moved to
 * the right rod. There are a couple of simple rules:
 * <ol>
 * <li>The top disk on any rod can be moved to another rod.
 * <li>At no time may a larger disk be placed on top of a smaller disk.
 * </ol>
 * The number of moves required is 2^n - 1 where n is the height of the tower and consequently, the
 * number of disks.
 * <p>
 * This is a standalone (i.e., not Web) Spring Boot application. In the {@link #main(String[])}
 * method, Spring Boot is started. Then, because the class implements CommandLineRunner, the
 * {@link #run(String...)} method is called after all Bean initialization and dependency injection
 * has been completed.
 * 
 * @author Promineo
 *
 */
@SpringBootApplication
public class TowerOfHanoi implements CommandLineRunner {

  /*
   * Spring detects the @Autowired annotation and automatically injects a managed Bean of type
   * HanoiLogic. This is the "player" that plays the game.
   */
  @Autowired
  private HanoiPlayer gamePlayer;

  /**
   * This is the entry point for the Spring Boot application.
   * 
   * @param args The args array is not used. The tower gets its height by reading tower.height
   *        attribute in src/main/resources/application.yaml.
   */
  public static void main(String[] args) {
    SpringApplication.run(TowerOfHanoi.class, args);
  }

  /**
   * This is required by the {@link CommandLineRunner} interface. It is called by Spring Boot once
   * all initialization and Dependency Injection has been completed.
   */
  @Override
  public void run(String... args) throws Exception {
    /* The player object is called to set up and play the game. */
    gamePlayer.playTowerOfHanoi();
  }
}
