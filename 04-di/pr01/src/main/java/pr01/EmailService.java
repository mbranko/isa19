package pr01;

import javax.inject.Singleton;

@Singleton
public class EmailService implements MessageService {

	public boolean sendMessage(String msg, String recipient) {
		System.out.println("Email Message sent to "+recipient+" with message="+msg);
		return true;
	}

}