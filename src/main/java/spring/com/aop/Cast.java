package spring.com.aop;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Cast {
	private Singer singer;
	
	public void setSinger(Singer s) {
		singer =  s;
	}
	
	public void execute() {
		singer.sing();
		singer.rest();
	}
	
	
	public static void main(String args[]) {
		GenericXmlApplicationContext gctx = new GenericXmlApplicationContext(); 
		gctx.load("classpath:spring/conf/app-context-aop.xml");
		gctx.refresh();
		
		Cast cast1 = gctx.getBean("cast1", Cast.class);
		cast1.execute();
		
		Cast cast2 = gctx.getBean("cast2", Cast.class);
		cast2.execute();
		
		gctx.close();
	}
}
