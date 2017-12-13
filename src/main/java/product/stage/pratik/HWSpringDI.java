package product.stage.pratik;

import product.stage.pratik.message.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import product.stage.pratik.conf.HWConfiguration;

public class HWSpringDI {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-context.xml");
		MessageRenderer messageRenderer = ctx.getBean("renderer", MessageRenderer.class);
		messageRenderer.render();
		
		//GenericXmlApplicationContext for reading annotations
		GenericXmlApplicationContext gctx = new GenericXmlApplicationContext();
		gctx.load("classpath:spring/app-context-annotation.xml");
		gctx.refresh();
		MessageRenderer gMessageRenderer = gctx.getBean("renderer", MessageRenderer.class);
		gMessageRenderer.render();
		
		//GenericXmlApplicationContext for reading XML
		GenericXmlApplicationContext gdctx = new GenericXmlApplicationContext();
		gdctx.load("classpath:spring/app-context.xml");
		gdctx.refresh();
		gMessageRenderer = gdctx.getBean("renderer", MessageRenderer.class);
		gMessageRenderer.render();
		
		// configuration classes
		ApplicationContext actx = new AnnotationConfigApplicationContext(HWConfiguration.class);
		actx.getBean("renderer", MessageRenderer.class).render();
		
	}

}
