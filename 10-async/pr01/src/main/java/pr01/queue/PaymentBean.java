package pr01.queue;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@MessageDriven(activationConfig={
    @ActivationConfigProperty(
        propertyName="destination",
        propertyValue="PaymentQueue"),
    @ActivationConfigProperty(
        propertyName="destinationType",
        propertyValue="javax.jms.Queue")
})
public class PaymentBean implements MessageListener {
  
  public void onMessage(Message msg) {
    if (msg instanceof ObjectMessage) {
      try {
        ObjectMessage obj = (ObjectMessage)msg;
        PaymentInfo info = (PaymentInfo)obj.getObject();
        System.out.println("[PaymentBean] " + info);
      } catch (JMSException ex) {
        ex.printStackTrace();
      }
    }
  }
}
