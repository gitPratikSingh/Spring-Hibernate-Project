package spring.com.xml;

import spring.org.*;

public abstract class AbstractMethodLookupBean {
	// spring will dynamically create a subclass of this class and provide an implementation of the abstarct method
	public abstract Singer getSinger();
}
