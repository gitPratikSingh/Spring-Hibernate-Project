package spring.com.aop;

public class ErrorBean {
	void errorProneMethod() throws Exception {
		throw new Exception("Generic Exception");
	}
	
	void anotherErrorProneMethod() throws IllegalArgumentException {
		throw new IllegalArgumentException("IllegalArgumentException");
	}
}
