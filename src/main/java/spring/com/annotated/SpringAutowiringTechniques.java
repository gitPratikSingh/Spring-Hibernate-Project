package spring.com.annotated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import spring.com.annotated.base.*;

@Component
@Lazy
public class SpringAutowiringTechniques {

	private Bar bar;
	private Foo foo;
	private Foo foodup;
	
	@Autowired
	public void setBar(Bar bar) {
		this.bar = bar;
		System.out.println("Setter Bar called");
	}
	
	@Autowired
	public void setFoo(Foo foo) {
		this.foo = foo;
		System.out.println("Setter Foo called");
	}
	
	@Autowired
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
		gctx.load("classpath:spring/conf/app-context-annotations.xml");
		gctx.refresh();
		
		System.out.println("Default annotations style is byType");
		SpringAutowiringTechniques bean  = gctx.getBean(SpringAutowiringTechniques.class);
		
		// prevent resource leak
		gctx.close();
	}

}
