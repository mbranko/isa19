package pr01;

import pr01.queue.CardType;
import pr01.queue.PaymentInfo;
import pr01.topic.NewsMessage;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.jms.*;
import java.math.BigDecimal;

@Stateless(name="ClientBean")
@Local(Client.class)
public class ClientBean implements Client {

  @Resource
  private ConnectionFactory connectionFactory;

  @Resource(name="PaymentQueue")
  private Queue queue;

  @Resource(name="NewsTopic")
  private Topic topic;

  @Override
  public void sendToQueue() {
    PaymentInfo msg1 = new PaymentInfo(CardType.VISA, "111111111", "2008/12",
        new BigDecimal("1350.32"));
    PaymentInfo msg2 = new PaymentInfo(CardType.VISA, "22222222", "2008/12",
        new BigDecimal("5324.33"));

    try {
      final Connection connection = connectionFactory.createConnection();
      connection.start();
      final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
      final MessageProducer payments = session.createProducer(queue);
      System.out.println("Sending message to queue: " + msg1);
      payments.send(session.createObjectMessage(msg1));
      System.out.println("Sending message to queue: " + msg2);
      payments.send(session.createObjectMessage(msg2));

      payments.close();
      session.close();
      connection.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public void sendToTopic() {
    NewsMessage msg1 = new NewsMessage("Poskupelo ulje", "Ulje je poskupelo za jos 350%...");
    NewsMessage msg2 = new NewsMessage("Poskupelo gorivo", "Benzin je poskupeo za jos 850%...");
    try {
      final Connection connection = connectionFactory.createConnection();
      connection.start();
      final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
      final MessageProducer news = session.createProducer(topic);
      System.out.println("Sending message to topic: " + msg1);
      news.send(session.createObjectMessage(msg1));
      System.out.println("Sending message to topic: " + msg2);
      news.send(session.createObjectMessage(msg2));

      news.close();
      session.close();
      connection.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
