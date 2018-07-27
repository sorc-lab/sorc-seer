package dependencyinjection.test;

import dependencyinjection.consumer.Consumer;
import dependencyinjection.injector.EmailServiceInjector;
import dependencyinjection.injector.MessageServiceInjector;
import dependencyinjection.injector.SMSServiceInjector;

public class MyMessageDITest
{
	public static void main(String[] args)
	{
		String msg = "Hello Mac.";
		String email = "macfisher01@gmail.com";
		String phone = "303-666-4444";
		
		MessageServiceInjector injector = null;
		Consumer app = null;
		
		// send email
		injector = new EmailServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, email);
		
		// send SMS
		injector = new SMSServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, phone);
	}
}
