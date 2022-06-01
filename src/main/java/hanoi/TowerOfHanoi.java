/**
 * 
 */
package hanoi;

import java.io.PrintWriter;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import hanoi.game.HanoiPlayer;
import hanoi.model.TowerWriter;

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
  
  /* Minimum and maximum tower height */
  private static final int MIN_HEIGHT = 1;
  private static final int MAX_HEIGHT = 10;
  
  private static final int DEF_HEIGHT = 3;

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
    int towerHeight = DEF_HEIGHT;
    PrintWriter printWriter = TowerWriter.getPrintWriter();
    String lf = System.lineSeparator();
    String def = "Setting tower height to default: " + towerHeight + lf;
    String usage = "Usage: TowerOfHanoi <height>" + lf;

    if(Objects.isNull(args) || args.length != 1) {
      printWriter.println(usage + def);
    }
    else {
      try {
        towerHeight = Integer.parseInt(args[0]);

        if(towerHeight < MIN_HEIGHT || towerHeight > MAX_HEIGHT) {
          printWriter.println(usage + "Height must be between " + MIN_HEIGHT + " and " + MAX_HEIGHT);
        }
      }
      catch (NumberFormatException e) {
        printWriter.println(usage + def);
      }
    }

    /* The player object is called to set up and play the game. */
      gamePlayer.playTowerOfHanoi(towerHeight);
  }
}
