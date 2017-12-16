package spring.com.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.org.*;

public class SpringAutowiringTechniques {

	private Bar bar;
	private Foo foo;
	private Foo foodup;
	
	public void setBar(Bar bar) {
		this.bar = bar;
		System.out.println("Setter Bar called");
	}
	
	public void setFoo(Foo foo) {
		this.foo = foo;
		System.out.println("Setter Foo called");
	}
	
	public void setFoodup(Foo foo) {
		this.foodup = foo;
		System.out.println("Setter Foodup called");
	}
	
	// needed for instantiation using setter injection
	public SpringAutowiringTechniques() {}
	
	public SpringAutowiringTechniques(Bar b) {
		this.bar = b;
		System.out.println("Constructor Bar called");
	}
	
	public SpringAutowiringTechniques(Bar b, Foo f) {
		this.bar = b;
		this.foo = f;
		System.out.println("Constructor Bar, Foo called");
	}
	public static void main(String[] args) {
		GenericXmlApplicationContext gctx = new GenericXmlApplicationContext();
		gctx.load("classpath:spring/conf/app-context-autowiring.xml");
		gctx.refresh();
		
		System.out.println("TargetByName");
		SpringAutowiringTechniques bean  = gctx.getBean("TargetByName", SpringAutowiringTechniques.class);
		
		System.out.println("\nTargetByType");
		bean  = gctx.getBean("TargetByType", SpringAutowiringTechniques.class);
		System.out.println(bean.foo == bean.foodup);
		
		System.out.println("\nTargetByType");
		bean  = gctx.getBean("TargetByConstructor", SpringAutowiringTechniques.class);
		
		// prevent resource leak
		gctx.close();
	}

}
