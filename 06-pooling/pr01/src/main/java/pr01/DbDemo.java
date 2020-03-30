package pr01;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.*;

public class DbDemo {

  private static Connection connection;

  public static void main(String[] args) throws Exception {

    // registracija drajvera za bazu
    Class.forName("org.h2.Driver");

    // otvaranje konekcije sa bazom
    // "jdbc:mysql://localhost:3306/naziv_seme"
    // java.sql.Connection
    connection = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");

    createSchema();
    insertData();
    select();
    insert();
    preparedStatement();
    callableStatement();
    System.out.println("===");
    select();

    // zatvaranje konekcije sa bazom
    connection.close();
  }

  /**
   * Kreira semu baze podataka iz fajla schema.sql
   * Kreira uskladistenu proceduru iz fajla storedprocedure-h2.sql
   *
   * Pogledaj i fajl storedprocedure-mysql.sql za primer uskladistene
   * procedure pisane za MySQL.
   */
  private static void createSchema() throws Exception {
    runScript("schema.sql");
    runScript("storedprocedure-h2.sql");
  }

  /**
   * Puni demo podatke u bazu iz skripta data.sql
   */
  private static void insertData() throws Exception {
    runScript("data.sql");
  }

  /**
   * Primer slanja SELECT upita u bazu.
   */
  private static void select() throws Exception {
    String query = "SELECT ime, prezime FROM nastavnici";
    Statement stmt = connection.createStatement();
    ResultSet rset = stmt.executeQuery(query);
    while (rset.next()) {
      System.out.println(rset.getString(1) + " " + rset.getString(2));
      //rset.getString(1);
      //rset.getInt(2);
      //rset.getBoolean(3);
      //rset.getDate(4);
      //rset.getFloat(5);
      //...
    }
    rset.close();
    stmt.close();
  }

  /**
   * Primer dodavanja jednog reda u tabelu.
   */
  private static void insert() throws Exception {
    String dml = "INSERT INTO NASTAVNICI (nastavnik_id, ime, prezime, zvanje)" + 
                 " VALUES (4, 'Zika', 'Zikic', 'docent')";    
    Statement stmt = connection.createStatement();
    int rowsAffected = stmt.executeUpdate(dml);
    stmt.close();
  }

  /**
   * Primer slanja vise uzastopnih INSERT naredbi u bazu
   * pomocu PreparedStatement
   */
  private static void preparedStatement() throws Exception {
    // Dodavanje novih nastavnika
    PreparedStatement stmt = connection.prepareStatement(
        "INSERT INTO nastavnici (nastavnik_id, ime, prezime, zvanje) " +
            "VALUES (?, ?, ?, ?)");
    stmt.setInt(1, 5);
    stmt.setString(2, "Sima");
    stmt.setString(3, "Simic");
    stmt.setString(4, "docent");
    stmt.executeUpdate();

    stmt.setInt(1, 6);
    stmt.setString(2, "Vasa");
    stmt.setString(3, "Vasic");
    stmt.setString(4, "docent");
    stmt.executeUpdate();

    stmt.close();
  }

  /**
   * Primer pozivanja uskladistene procedure
   */
  private static void callableStatement() throws Exception {
    CallableStatement stmt = connection.prepareCall(
        "{? = call povezi (?, ?, ?)}");
    stmt.setString(1, "Sima");
    stmt.setString(2, "Simic");
    stmt.setString(3, "Osnovi racunarstva");
    int status = stmt.executeUpdate();
    System.out.println("Status poziva stored procedure: " + status);
    stmt.close();

  }

  /**
   * Izvrsava dati SQL skript nad otvorenom konekcijom. Podrazumevani
   * delimiter SQL naredbi je ;
   *
   * @param fileName Naziv fajla sa SQL skriptom
   */
  private static void runScript(String fileName) throws Exception {
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

  /**
   * Primer uskladistene procedure pisane za H2 bazu. Ova baza je
   * specificna po tome sto se uskladistene procedure pisu u Javi,
   * umesto u nekom proceduralnom SQL dijalektu. Za primer takve
   * procedure pisane za MySQL bazu, pogledaj fajl
   * storedprocedure-mysql.sql
   *
   * Funkcija sluzi za povezivanje nastavnika datog sa imenom i
   * prezimenom i predmeta datog sa nazivom.
   *
   * @param c Otvorena konekcija sa bazom
   * @param ime Ime nastavnika
   * @param prezime Prezime nastavnika
   * @param naziv Naziv predmeta
   */
  public static void povezi(Connection c, String ime, String prezime, String naziv) throws Exception {
    PreparedStatement ps1 = c.prepareStatement("SELECT nastavnik_id FROM nastavnici WHERE ime=? AND prezime=?");
    ps1.setString(1, ime);
    ps1.setString(2, prezime);
    ResultSet rs1 = ps1.executeQuery();
    if (rs1.next()) {
      int nastavnikId = rs1.getInt(1);
      PreparedStatement ps2 = c.prepareStatement("SELECT predmet_id FROM predmeti WHERE naziv=?");
      ps2.setString(1, naziv);
      ResultSet rs2 = ps2.executeQuery();
      if (rs2.next()) {
        int predmetId = rs2.getInt(1);
        PreparedStatement ps3 = c.prepareStatement("INSERT INTO predaje (nastavnik_id, predmet_id) VALUES (?, ?)");
        ps3.setInt(1, nastavnikId);
        ps3.setInt(2, predmetId);
        ps3.executeUpdate();
        ps3.close();
      }
      rs2.close();
      ps2.close();
    }
    rs1.close();
    ps1.close();
  }
}
