package spring.com.annotated;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Lookup;

@Component("abstractMLBean")
public abstract class AbstractMethodLookupBean {
	// spring will dynamically create a subclass of this class and provide an implementation of the abstarct method
	@Lookup("singer")
	public abstract Singer getSinger();
}
