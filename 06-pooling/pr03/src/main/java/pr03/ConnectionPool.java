package pr03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ConnectionPool {

  /** Vraca jedinu (singleton) instancu poola. */
  public static ConnectionPool getInstance() {
    return instance;
  }

  /** Uzima jednu konekciju iz poola. */
  public synchronized Connection checkOut() throws SQLException {
    Connection conn = null;
    if (freeConnections.size() > 0) {
      conn = freeConnections.get(0);
      freeConnections.remove(0);
      usedConnections.add(conn);
    } else {
      if (connectCount < maxConnections) {
        conn = DriverManager.getConnection(
          jdbcURL, username, password);
        usedConnections.add(conn);
        connectCount++;
      } else {
        try {
          this.wait();
          conn = freeConnections.get(0);
          freeConnections.remove(0);
          usedConnections.add(conn);
        } catch (InterruptedException ex) {
          ex.printStackTrace();
        }
      }
    }
    System.out.println("[ConnectionPool] checking out: " + conn.toString());
    return conn;
  }

  /** vraca konekciju u pool. */
  public synchronized void checkIn(Connection aConn) {
    if (aConn ==  null)
      return;
    if (usedConnections.remove(aConn)) {
      freeConnections.add(aConn);
      while (freeConnections.size() > maxIdleConnections) {
        int lastOne = freeConnections.size() - 1;
        Connection conn = freeConnections.get(lastOne);
        try { conn.close(); } catch (SQLException ex) { }
        freeConnections.remove(lastOne);
      }
      this.notify();
    }
  }

  /** konstruise pool. */
  protected ConnectionPool(String driver, String jdbcURL, String username,
      String password, int preconnectCount, int maxIdleConnections,
      int maxConnections) throws ClassNotFoundException, SQLException {

    freeConnections = new ArrayList<Connection>();
    usedConnections = new ArrayList<Connection>();
    this.jdbcURL = jdbcURL;
    this.username = username;
    this.password = password;
    this.maxIdleConnections = maxIdleConnections;
    this.maxConnections = maxConnections;

    Class.forName(driver);
    for (int i = 0; i < preconnectCount; i++) {
      Connection conn = DriverManager.getConnection(
        jdbcURL, username, password);
      conn.setAutoCommit(false);
      freeConnections.add(conn);
    }
    connectCount = preconnectCount;
  }

  private static ConnectionPool instance;
  private String jdbcURL;
  private String username;
  private String password;
  private int connectCount;
  private int maxIdleConnections;
  private int maxConnections;
  private List<Connection> usedConnections;
  private List<Connection> freeConnections;

  static {
    ResourceBundle bundle =
      PropertyResourceBundle.getBundle(
          "ConnectionPool");
    String driver = bundle.getString("driver");
    String jdbcURL = bundle.getString("jdbcURL");
    String username = bundle.getString("username");
    String password = bundle.getString("password");
    int preconnectCount = 0;
    int maxIdleConnections = 10;
    int maxConnections = 10;
    try {
      preconnectCount = Integer.parseInt(
        bundle.getString("preconnectCount"));
      maxIdleConnections = Integer.parseInt(
        bundle.getString("maxIdleConnections"));
      maxConnections = Integer.parseInt(
        bundle.getString("maxConnections"));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    try {
      instance = new ConnectionPool(driver,
        jdbcURL, username, password,
        preconnectCount, maxIdleConnections,
        maxConnections);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
