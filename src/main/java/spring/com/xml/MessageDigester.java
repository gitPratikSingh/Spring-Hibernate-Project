package spring.com.xml;

import java.security.MessageDigest;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigester {

	MessageDigest digest1, digest2;
	
	public void setDigest1(MessageDigest digest) {
		this.digest1 = digest;
	}
	
	public void setDigest2(MessageDigest digest) {
		this.digest2 = digest;
	}
	
	public void digest(String msg) {
		System.out.println("Digest 1");
		digest(msg, digest1);
		
		System.out.println("Digest 2");
		digest(msg, digest2);
	}
	private void digest(String msg, MessageDigest digest) {
		System.out.println("Algo: "+ digest.getAlgorithm());
		digest.reset();
		
		byte [] bytes = msg.getBytes();
		byte [] out = digest.digest(bytes);
		System.out.println(out);
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext gctx = new GenericXmlApplicationContext(); 
		gctx.load("classpath:spring/conf/app-context-factorybeans.xml");
		gctx.refresh();
		
		MessageDigester messageDigester = gctx.getBean("MessageDigester", MessageDigester.class);
		messageDigester.digest("This is a simple FactoryBean!");
		
		gctx.close();
	}

}
