package product.stage.pratik.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("renderer")
public class StandardOutMessageRenderer implements MessageRenderer{
	private MessageProvider messageProvider;
	
	public void render() {
		
		if(this.messageProvider==null) {
			throw new RuntimeException("You must set the property messageProvider in class:"
				+	StandardOutMessageRenderer.class.getName());
		}
		
		System.out.println(messageProvider.getMessage());
	}
	
	
	@Autowired
	public void setMessageProvider(MessageProvider mprovider) {
		this.messageProvider = mprovider;
	}
	
	public MessageProvider getMessageProvider() {
		return this.messageProvider;
	}
}
