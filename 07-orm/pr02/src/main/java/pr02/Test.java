package pr02;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;

public class Test {
  public static void main(String[] args) throws Exception {
    Class.forName("org.h2.Driver");
    Connection conn = DriverManager.getConnection(
        "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "sa", "");
    runScript(conn, "init.sql");
    conn.close();
    
    User zika = new User(1, "Zika", "Zikic");
    User pera = new User(2, "Pera", "Peric");
    User laza = new User(3, "Laza", "Lazic");
    
    // upisi ziku, peru i lazu
    zika.insert();
    System.out.println("Inserted: " + zika);
    pera.insert();
    System.out.println("Inserted: " + pera);
    laza.insert();
    System.out.println("Inserted: " + laza);
    
    // pronadji korisnika sa userID=2
    User user = new User();
    user.load(2);
    System.out.println("Loaded: " + user);
    
    // azuriraj podatke tom korisniku
    user.setPassword("***");
    user.update();
    System.out.println("Updated: " + user);
  }

  private static void runScript(Connection connection, String fileName) throws Exception {
    Reader reader = Resources.getResourceAsReader(fileName);
    ScriptRunner runner = new ScriptRunner(connection);
    runner.setDelimiter(";");
    runner.setLogWriter(null);
    runner.setErrorLogWriter(new PrintWriter(
        new OutputStreamWriter(System.err, "UTF8")));
    runner.runScript(reader);
    connection.commit();
    reader.close();
  }
}
