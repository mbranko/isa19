package pr03;

public class Main {
  public static void main(String[] args) throws Exception {
    System.out.println(ANSI_RED + "\n### LOST UPDATE ###" + ANSI_RESET);
    System.out.println(ANSI_YELLOW + "\nMySQL MyISAM engine" + ANSI_RESET);
    LostUpdate.run("schema1.sql");
    System.out.println(ANSI_YELLOW + "\nMySQL INNODB engine" + ANSI_RESET);
    LostUpdate.run("schema2.sql");

    System.out.println(ANSI_RED + "\n### DIRTY READ ###" + ANSI_RESET);
    System.out.println(ANSI_YELLOW + "\nMySQL MyISAM engine" + ANSI_RESET);
    DirtyRead.run("schema1.sql");
    System.out.println(ANSI_YELLOW + "\nMySQL INNODB engine" + ANSI_RESET);
    DirtyRead.run("schema2.sql");

    System.out.println(ANSI_RED + "\n### UNREPEATABLE READ ###" + ANSI_RESET);
    UnrepeatableRead.run("schema2.sql");

    System.out.println(ANSI_RED + "\n### PHANTOM READ ###" + ANSI_RESET);
    PhantomRead.run("schema2.sql");
  }

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
}