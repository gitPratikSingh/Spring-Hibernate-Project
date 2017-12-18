package spring.com.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class LocalProperties {

	private String applicationHome;
	private String userHome;
	
	public void setApplicationHome(String appHome) {
		this.applicationHome = appHome;
	}
	
	public void setUserHome(String userHome) {
		this.userHome = userHome;
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext gctx = new GenericXmlApplicationContext(); 
		gctx.load("classpath:spring/conf/app-context-properties.xml");
		gctx.refresh();
		
		LocalProperties localProperties = gctx.getBean("localProperties", LocalProperties.class);
		
		System.out.println("applicationHome:"+localProperties.applicationHome);
		System.out.println("userHome:"+localProperties.userHome);
		
		gctx.close();

	}

}
