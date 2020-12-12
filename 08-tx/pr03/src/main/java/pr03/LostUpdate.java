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

public class LostUpdate extends Demo {

  public static void run(String script) throws Exception {
    setup(script, Connection.TRANSACTION_READ_UNCOMMITTED);
    final CountDownLatch latch = new CountDownLatch(2);
    BigDecimal original = new BigDecimal(1000);
    BigDecimal correct = new BigDecimal(1200);
    System.out.println("Original value: " + original);

    Runnable r1 = () -> {
      try {
        System.out.println("Thread 1: SELECT --> " + getBalance(conn1));
        Thread.sleep(1000);
        System.out.println("Thread 1: UPDATE --> " + updateBalance(conn1));
        Thread.sleep(1000);
        System.out.println("Thread 1: COMMIT");
        conn1.commit();
        latch.countDown();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    };

    Runnable r2 = () -> {
      try {
        Thread.sleep(500);
        System.out.println("\t\t\t\tThread 2: SELECT --> " + getBalance(conn2));
        Thread.sleep(1000);
        System.out.println("\t\t\t\tThread 2: UPDATE --> " + updateBalance(conn2));
        Thread.sleep(1000);
        System.out.println("\t\t\t\tThread 2: ROLLBACK");
        conn2.rollback();
        latch.countDown();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    };

    new Thread(r1).start();
    new Thread(r2).start();
    latch.await();
    BigDecimal balance1 = getBalance(conn1);
    BigDecimal balance2 = getBalance(conn2);
    System.out.print("\nFinally in DB [conn1]: " + balance1);
    System.out.println("\tFinally in DB [conn2]: " + balance2);
    System.out.println("Correct value: " + correct);
    teardown();
  }
}