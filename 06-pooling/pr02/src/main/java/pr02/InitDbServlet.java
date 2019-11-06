package pr02;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Ovaj servlet sluzi samo da kreira semu baze i 
 * napuni podatke pre nego sto drugi servlet
 * pristupi bazi.
 */
public class InitDbServlet extends HttpServlet {

  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    try {
      Class.forName("org.h2.Driver");
      Connection conn = DriverManager.getConnection(
          "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "sa", "");
      runScript(conn, "schema.sql");
      runScript(conn, "data.sql");
      conn.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
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

  private static final long serialVersionUID = -5829052109034248195L;
}