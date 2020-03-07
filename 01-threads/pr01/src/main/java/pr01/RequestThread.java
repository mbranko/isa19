package pr01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

class RequestThread extends Thread {

  private static final Logger logger = LoggerFactory.getLogger(RequestThread.class);

  private Socket socket;

  private BufferedReader in;

  private BufferedWriter out;

  private String method;

  private String url;

  private boolean success;

  private int requestCount;

  public void setSocket(Socket s) {
    this.socket = s;
  }

  public void setRequestCount(int requestCount) {
    this.requestCount = requestCount;
  }

  public void run() {
    try {
      in = new BufferedReader(new InputStreamReader(
          socket.getInputStream(), "UTF8"));
      out = new BufferedWriter(new OutputStreamWriter(
          socket.getOutputStream(), "UTF8"));

      parsirajZahtev();
      obradiZahtev();
      posaljiOdgovor();

      in.close();
      out.close();
    } catch (IOException ex) {
      logger.error("Communication error", ex);
    }
  }

  private void parsirajZahtev() throws IOException {
    String line1 = in.readLine();
    if (line1 == null) {
      method = "NONE";
    } else {
      String[] parts = line1.split(" ");
      method = parts[0];
      url = parts[1];
    }
  }

  private void obradiZahtev() {
    success = "GET".equals(method.toUpperCase());
    if (requestCount % 7 == 0)
      try { Thread.sleep(250); } catch (InterruptedException ex) {}
    if (requestCount % 11 == 0)
      try { Thread.sleep(450); } catch (InterruptedException ex) {}
  }

  private void posaljiOdgovor() throws IOException {
    if (success) {
      out.write("HTTP/1.0 200 OK\n");
      out.write("Content-Type: text/html\n");
      out.write("Content-Length: " + successfulResponse.length() + "\n\n");
      out.write(successfulResponse);
      out.close();
    } else {
      out.write("HTTP/1.0 405 Method Not Allowed\n");
      out.write("Allow: GET\n");
      out.close();
    }
  }

  private String successfulResponse = 
    "<!DOCTYPE html><html><head></head><body><h1>Success</h1></body></html>";
}
