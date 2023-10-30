package pr03;

import java.math.BigDecimal;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.CountDownLatch;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;

public class Demo {

  protected static Connection conn1;
  protected static Connection conn2;

  protected static void setup(String script, int isolationLevel) throws Exception {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn1 = DriverManager.getConnection("jdbc:mysql://localhost/txtest?serverTimezone=UTC", "txtest", "txtest");
    conn1.setAutoCommit(false);
    runScript(script, conn1);
    conn1.commit();
    conn1.setTransactionIsolation(isolationLevel);
    conn2 = DriverManager.getConnection("jdbc:mysql://localhost/txtest?serverTimezone=UTC", "txtest", "txtest");
    conn2.setAutoCommit(false);
    conn2.setTransactionIsolation(isolationLevel);
  }

  protected static void teardown() throws Exception {
    conn1.close();
    conn2.close();
  }

  protected static BigDecimal getBalance(Connection conn) throws Exception {
    BigDecimal balance = null;
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery("SELECT account_number, balance FROM bank_account WHERE account_number='1234567890123'");
    if (rs.next()) {
      balance = rs.getBigDecimal(2);
    }
    rs.close();
    st.close();
    return balance;
  }

  protected static BigDecimal updateBalance(Connection conn) throws Exception {
    PreparedStatement p = conn.prepareStatement("UPDATE bank_account SET balance=balance+200 WHERE account_number='1234567890123'");
    p.executeUpdate();
    p.close();
    return getBalance(conn);
  }

  protected static BigDecimal insertAccount(Connection conn) throws Exception {
    BigDecimal balance = new BigDecimal(2000);
    PreparedStatement p = conn.prepareStatement("INSERT INTO bank_account (id, account_number, balance) VALUES (?, ?, ?)");
    p.setInt(1, 2);
    p.setString(2, "1234567890123");
    p.setBigDecimal(3, balance);
    p.executeUpdate();
    p.close();
    return balance;
  }

  protected static String getBalances(Connection conn) throws Exception {
    String result = null;
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery("SELECT account_number, balance FROM bank_account WHERE account_number='1234567890123'");
    if (rs.next()) {
      result = rs.getBigDecimal(2).toString();
    }
    if (rs.next()) {
      result += "; " + rs.getBigDecimal(2).toString();
    }
    rs.close();
    st.close();
    return result;
  }

  protected static void runScript(String fileName, Connection connection) throws Exception {
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