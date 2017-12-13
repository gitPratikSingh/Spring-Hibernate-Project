package product.stage.pratik.inject;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectionSimple {

	
	private int value;
	private String name;
	
	public void setValue(int val) {
		this.value =val;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return Integer.toString(value) + ", "+ name;
	}
	
	
	public static void main(String[] args) {
		
		GenericXmlApplicationContext gctx = new GenericXmlApplicationContext();
		gctx.load("classpath:spring/app-context-inject.xml");
		gctx.refresh();
		
		System.out.println(gctx.getBean("injection", InjectionSimple.class).toString());
		
		gctx.close();

	}

}
