package product.stage.pratik.message;

public class StandardOutMessageRenderer implements MessageRenderer{
	private MessageProvider messageProvider;
	
	public void render() {
		
		if(this.messageProvider==null) {
			throw new RuntimeException("You must set the property messageProvider in class:"
				+	StandardOutMessageRenderer.class.getName());
		}
		
		System.out.println(messageProvider.getMessage());
	}
	
	public void setMessageProvider(MessageProvider provider) {
		this.messageProvider = provider;
	}
	
	public MessageProvider getMessageProvider() {
		return this.messageProvider;
	}
}
