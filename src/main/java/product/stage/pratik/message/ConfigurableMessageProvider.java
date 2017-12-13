package product.stage.pratik.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mprovider")
public class ConfigurableMessageProvider implements MessageProvider{

	private String message;
	
	@Autowired
	ConfigurableMessageProvider(String message){
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
