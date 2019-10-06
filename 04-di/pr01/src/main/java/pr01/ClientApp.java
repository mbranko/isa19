package pr01;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ClientApp {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new AppInjector());		
		
		MyApp app = injector.getInstance(MyApp.class);
		
		app.sendMessage("Hi Branko", "branko@foobar.com");
	}

}