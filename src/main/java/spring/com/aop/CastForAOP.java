package spring.com.aop;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CastForAOP {
	private Singer singer;
		
		public void setSinger(Singer s) {
			singer =  s;
		}
		
		public void execute() {
			singer.sing();
			singer.sing(10);
			singer.rest();
		}
		
		
		public static void main(String args[]) {
			GenericXmlApplicationContext gctx = new GenericXmlApplicationContext(); 
			gctx.load("classpath:spring/conf/app-context-aop-namespace.xml");
			gctx.refresh();
			
			CastForAOP cast = gctx.getBean("cast", CastForAOP.class);
			cast.execute();
			
			gctx.close();
		}
}
