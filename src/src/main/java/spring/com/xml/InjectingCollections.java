package spring.com.xml;

import java.util.Map;
import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectingCollections {
	
	private Map<String, Object> map;
	
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	public static void main(String[] args) {
		
		GenericXmlApplicationContext gctx = new GenericXmlApplicationContext(); 
		gctx.load("classpath:spring/conf/app-context.xml");
		gctx.refresh();
		
		InjectingCollections bean = gctx.getBean("InjectingCollections", InjectingCollections.class);
		System.out.println(bean.map.toString());
		
	}

}
