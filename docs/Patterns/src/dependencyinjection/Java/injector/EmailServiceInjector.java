package dependencyinjection.injector;

import dependencyinjection.consumer.Consumer;
import dependencyinjection.consumer.MyDIApplication;
import dependencyinjection.service.EmailServiceImpl;

public class EmailServiceInjector implements MessageServiceInjector
{
	@Override
	public Consumer getConsumer()
	{
		return new MyDIApplication(new EmailServiceImpl());
	}
}
