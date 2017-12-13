package product.stage.pratik;

import org.springframework.context.support.GenericXmlApplicationContext;
import java.util.*;

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
		map.entrySet().stream().forEach(e -> System.out.println(
		"Key: " + e.getKey() + " - Value: " + e.getValue()));
		System.out.println("\nProperties contents:\n");
		
		props.entrySet().stream().forEach(e -> System.out.println(
		"Key: " + e.getKey() + " - Value: " + e.getValue()));
		System.out.println("\nSet contents:\n");
		
		set.forEach(obj -> System.out.println("Value: " + obj));
		System.out.println("\nList contents:\n");
		
		list.forEach(obj -> System.out.println("Value: " + obj));
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext gtx = new GenericXmlApplicationContext();
		gtx.load("classpath:spring/app-context-collections.xml");
		gtx.refresh();
		
		//gtx.getBean("injectCollections", InjectCollections.class).display();
		
	}
}
