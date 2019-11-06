package pr02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {

  private int userID;
  private String username;
  private String password;

  public User() {
  }

  public User(int userID, String username, String password) {
    this.userID = userID;
    this.username = username;
    this.password = password;
  }
  
  /**
   * Proverava da li korisnik sa datim username i password postoji u bazi.
   * @return true ako postoji
   */
  public boolean login() {
    boolean success = false;
    Connection conn = null;
    try {
      conn = ConnectionPool.getInstance().checkOut();
      PreparedStatement p = conn.prepareStatement(
          "SELECT user_id FROM users WHERE username=? AND pasword=?");
      p.setString(1, username);
      p.setString(2, password);
      ResultSet r = p.executeQuery();
      if (r.next()) {
        userID = r.getInt(1);
        success = true;
      }
      r.close();
      p.close();
      conn.commit();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionPool.getInstance().checkIn(conn);
    }
    return success;
  }
  
  /**
   * Ucitava podatke o korisniku na osnovu njegovog userID-a
   * @param userID identifikator korisnika
   * @return true ako je operacija uspesna
   */
  public boolean load(int userID) {
    boolean success = false;
    Connection conn = null;
    try {
      conn = ConnectionPool.getInstance().checkOut();
      PreparedStatement p = conn.prepareStatement(
          "SELECT username, pasword FROM users WHERE user_id=?");
      p.setInt(1, userID);
      ResultSet r = p.executeQuery();
      if (r.next()) {
        this.userID = userID;
        username = r.getString(1);
        password = r.getString(2);
        success = true;
      }
      r.close();
      p.close();
      conn.commit();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionPool.getInstance().checkIn(conn);
    }
    return success;
  }
  
  /**
   * Dodaje korisnika u bazu.
   * @return true ako je operacija uspesna
   */
  public boolean insert() {
    boolean success = false;
    Connection conn = null;
    try {
      conn = ConnectionPool.getInstance().checkOut();
      PreparedStatement p = conn.prepareStatement(
          "INSERT INTO users (user_id, username, pasword) VALUES (?, ?, ?)");
      p.setInt(1, userID);
      p.setString(2, username);
      p.setString(3, password);
      int rowsAffected = p.executeUpdate();
      success = rowsAffected > 0;
      p.close();
      conn.commit();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionPool.getInstance().checkIn(conn);
    }
    return success;
    
  }
  
  /**
   * Azurira korisnikove podatke u bazi.
   * @return true ako je operacija uspesna
   */
  public boolean update() {
    boolean success = false;
    Connection conn = null;
    try {
      conn = ConnectionPool.getInstance().checkOut();
      PreparedStatement p = conn.prepareStatement(
          "UPDATE users SET username=?, pasword=? WHERE user_id=?");
      p.setString(1, username);
      p.setString(2, password);
      p.setInt(3, userID);
      int rowsAffected = p.executeUpdate();
      success = rowsAffected > 0;
      p.close();
      conn.commit();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionPool.getInstance().checkIn(conn);
    }
    return success;
  }
  
  /**
   * Brise korisnika iz baze.
   * @return true ako je operacija uspesna
   */
  public boolean delete() {
    boolean success = false;
    Connection conn = null;
    try {
      conn = ConnectionPool.getInstance().checkOut();
      PreparedStatement p = conn.prepareStatement(
          "DELETE FROM users WHERE user_id=?");
      p.setInt(1, userID);
      int rowsAffected = p.executeUpdate();
      success = rowsAffected > 0;
      p.close();
      conn.commit();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionPool.getInstance().checkIn(conn);
    }
    return success;
  }
  
  public int getUserID() {
    return userID;
  }
  public void setUserID(int userID) {
    this.userID = userID;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  public String toString() {
    return "[User] " + userID + ":" + username + ":" + password;
  }
}
