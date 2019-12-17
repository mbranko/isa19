package pr01.topic;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@MessageDriven(activationConfig={
    @ActivationConfigProperty(
        propertyName="destination",
        propertyValue="NewsTopic"),
    @ActivationConfigProperty(
        propertyName="destinationType",
        propertyValue="javax.jms.Topic")
})
public class NewsReader implements MessageListener {

  public void onMessage(Message msg) {
    if (msg instanceof ObjectMessage) {
      try {
        ObjectMessage obj = (ObjectMessage)msg;
        NewsMessage news = (NewsMessage)obj.getObject();
        System.out.println("[NewsReader] Received news: " + news);
      } catch (JMSException ex) {
        ex.printStackTrace();
      }
    }
  }

}
