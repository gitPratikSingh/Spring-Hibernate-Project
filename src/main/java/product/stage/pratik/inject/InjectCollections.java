package product.stage.pratik.inject;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectCollections {
	private Map<String, Object> map;
	private Properties props;
	private Set set;
	private List list;
	
	
	public void setMap(Map mp) {
		map=mp;
	}
	
	public void setSet(Set st) {
		set=st;
	}
	
	public void setList(List ls) {
		list=ls;
	}
	
	public void setProps(Properties p) {
		props=p;
	}
	
	public void display() {
		
		System.out.println("Map contents:\n");
		Set<Entry<String, Object>> e = map.entrySet();
		for(Entry<String, Object> el:e) {
			System.out.println("Key:"+el.getKey()+", Value:"+el.getValue());
		}
		/*
		.forEach(e -> System.out.println(
		"Key: " + e.getKey() + " - Value: " + e.getValue()));
		System.out.println("\nProperties contents:\n");
		
		props.entrySet().stream().forEach(e -> System.out.println(
		"Key: " + e.getKey() + " - Value: " + e.getValue()));
		System.out.println("\nSet contents:\n");
		*/
		}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext gtx = new GenericXmlApplicationContext();
		gtx.load("classpath:spring/app-context-collections.xml");
		gtx.refresh();
		
		//gtx.getBean("injectCollections", InjectCollections.class).display();
		
	}
}
