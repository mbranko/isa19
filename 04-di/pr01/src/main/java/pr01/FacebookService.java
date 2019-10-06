package pr01;

import javax.inject.Singleton;

@Singleton
public class FacebookService implements MessageService {

	public boolean sendMessage(String msg, String recipient) {
		System.out.println("Message sent to Facebook user "+recipient+" with message="+msg);
		return true;
	}

}