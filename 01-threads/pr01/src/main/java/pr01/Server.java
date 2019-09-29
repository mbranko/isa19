package pr01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class Server {

  public static final int SERVER_PORT = 8080;

  private static final Logger logger = LoggerFactory.getLogger(Server.class);

  public static void main(String[] args) {
    try {
      ServerSocket ss = new ServerSocket(SERVER_PORT);
      logger.info("Listening for HTTP clients on " + SERVER_PORT);
      while (true) {
        Socket s = ss.accept();
        logger.info("Client accepted: " + s.getInetAddress().toString());
        RequestThread t = new RequestThread();
        t.setSocket(s);
        t.start();
      }
    } catch (IOException ex) {
      logger.error("Communication error", ex);
    }
  }  
}
