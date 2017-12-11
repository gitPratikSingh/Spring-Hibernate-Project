package product.stage.pratik.message;

public interface MessageRenderer {
	
	// any implementation of MR is decoupled from the responsibility of message retrieval
	
	void render();
	void setMessageProvider(MessageProvider mp);
	MessageProvider getMessageProvider();
}
