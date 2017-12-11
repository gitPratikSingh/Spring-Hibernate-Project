package product.stage.pratik;

import product.stage.pratik.message.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HWSpringDI {

	public static void main(String[] args) {
		/*
		MessageRenderer messageRenderer = new StandardOutMessageRenderer();
		MessageProvider messageProvider = new HelloWorldMessageProvider();
		messageRenderer.setMessageProvider(messageProvider);
		messageRenderer.render();*/
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-context.xml");
		MessageRenderer messageRenderer = ctx.getBean("renderer", MessageRenderer.class);
		messageRenderer.render();
	}

}
