package hanoi.model;

import java.io.PrintWriter;

public class TowerWriter {
  /*
   * A Writer is set up using the system console so that we can print pretty pictures in Unicode if
   * desired. Actually, it should print just as well using a PrintStream. This illustrates the many
   * design decisions that are made while developing an application. Some are better than others...
   */
  private static PrintWriter printWriter = new PrintWriter(System.out, true);

  public static PrintWriter getPrintWriter() {
    return printWriter;
  }
  
  public static void setPrintWriter(PrintWriter pw) {
    printWriter = pw;
  }
}
