package spring.com.annotated;

import java.util.Map;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.*;
@Service("InjectingCollections")
public class InjectingCollections {
	@Resource(name="map")
	private Map<String, Object> map;
	
	public static void main(String[] args) {
		
		GenericXmlApplicationContext gctx = new GenericXmlApplicationContext(); 
		gctx.load("classpath:spring/conf/app-context-annotations.xml");
		gctx.refresh();
		
		InjectingCollections bean = gctx.getBean("InjectingCollections", InjectingCollections.class);
		System.out.println(bean.map.toString());
		
	}

}
