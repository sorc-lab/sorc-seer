package test;

import consumer.Consumer;
import injector.EmailServiceInjector;
import injector.MessageServiceInjector;
import injector.SMSServiceInjector;

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
