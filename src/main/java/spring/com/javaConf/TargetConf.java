package spring.com.javaConf;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.GenericApplicationContext;

import spring.com.annotated.base.*;
import spring.com.annotated.SpringAutowiringTechniques;

@Configuration
@Lazy
public class TargetConf {
	
	@Bean
	@Primary
	public Foo Foo() {
		return new Foo();
	}
	
	@Bean
	public Foo Foodup() {
		return new Foo();
	}
	
	@Bean
	public Bar Bar() {
		return new Bar();
	}
	
	@Bean
	public SpringAutowiringTechniques springAutowiringTechniques() {
		return new SpringAutowiringTechniques();
	}
	
	public static void main(String[] args) {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(TargetConf.class);
		
		ctx.getBean(SpringAutowiringTechniques.class);
		
		ctx.close();
	}

}
