package spring.com.xml;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

import spring.org.StandardLookupBean;

public class LookupMethodInjection {

	public static void main(String[] args) {
		GenericXmlApplicationContext gctx = new GenericXmlApplicationContext();
		gctx.load("classpath:spring/conf/app-context-method-lookup.xml");
		gctx.refresh();

		AbstractMethodLookupBean al = gctx.getBean("abstractMLBean", AbstractMethodLookupBean.class);
		StandardLookupBean sl = gctx.getBean("standardLBean", StandardLookupBean.class);
		
		System.out.println(al.getSinger() == sl.getMySinger());
		System.out.println(al.getSinger() == al.getSinger());
		System.out.println(sl.getMySinger() == sl.getMySinger());
		
		StopWatch sw = new StopWatch();
		sw.start();
		
		for(int i=0; i<100000; i++) {
			sl.getMySinger();
		}
		
		sw.stop();
		System.out.println(sw.prettyPrint());
		
		StopWatch swl = new StopWatch();
		
		swl.start();
		
		for(int i=0; i<100000; i++) {
			al.getSinger();
		}
		
		swl.stop();
		System.out.println(swl.prettyPrint());
	
		gctx.close();
	}

}
