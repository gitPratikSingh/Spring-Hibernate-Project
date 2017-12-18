package spring.com.xml.EventHandling;

import org.springframework.context.ApplicationEvent;

public class MessageEvent extends ApplicationEvent{
	
	private String message;
	
	public MessageEvent(Object source, String msg) {
		super(source);
		message = msg;
	}
	
	public String getMessage() {
		return message;
	}
}
