package spring.com.xml;

import java.security.MessageDigest;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageDigestFactoryBean implements InitializingBean, FactoryBean<MessageDigest> {
	
	private String algoName = "MD5";
	private MessageDigest messageDigest;
	
	public void setAlgoName(String algoName) {
		this.algoName = algoName;	
	}
	
	@Override
	public MessageDigest getObject() throws Exception {
		return this.messageDigest;
	}

	@Override
	public Class<MessageDigest> getObjectType() {
		return MessageDigest.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.messageDigest = MessageDigest.getInstance(algoName);
	}

}
