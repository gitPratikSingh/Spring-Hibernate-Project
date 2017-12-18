package spring.com.xml.EventHandling;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Publisher implements ApplicationContextAware{

	private ApplicationContext ctx;
	
	public void publish(String msg) {
		ctx.publishEvent(new MessageEvent(this, msg));
	}
	
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx = ctx;
	}

	public static void main(String args[]) {
		GenericXmlApplicationContext gctx = new GenericXmlApplicationContext(); 
		gctx.load("classpath:spring/conf/app-context-events.xml");
		gctx.refresh();
		
		gctx.getBean("Publisher", Publisher.class).publish("Hi this is a sample message.Anybody there?");
		
		gctx.close();
	}
}
