package product.stage.pratik.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import product.stage.pratik.message.HelloWorldMessageProvider;
import product.stage.pratik.message.MessageProvider;
import product.stage.pratik.message.MessageRenderer;
import product.stage.pratik.message.StandardOutMessageRenderer;


@Configuration
public class HWConfiguration {
	
	@Bean
	public MessageProvider provider() {
		return new HelloWorldMessageProvider();
	}
	
	@Bean
	public MessageRenderer renderer() {
		return new StandardOutMessageRenderer();
	}
}
