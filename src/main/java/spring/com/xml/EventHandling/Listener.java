package spring.com.xml.EventHandling;

import org.springframework.context.ApplicationListener;

public class Listener implements ApplicationListener<MessageEvent>{

	@Override
	public void onApplicationEvent(MessageEvent messageEvent) {
		System.out.println("Received: " + messageEvent.getMessage());
	}

}
