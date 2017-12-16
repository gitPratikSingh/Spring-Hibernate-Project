package spring.com.beanlifecycle.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Singer {
	
	private static String DEFAULT_NAME = "PratikSingh";
	private int age = Integer.MIN_VALUE;
	private String name;
	
	public void setAge(int ag) {
		age = ag;
	}
	public void setName(String nm) {
		name = nm;
	}
	
	public void init() throws Exception {
		if(age==Integer.MIN_VALUE) {
			throw new Exception();
		}
		
		if(name==null) {
			name = this.DEFAULT_NAME;
		}
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext gctx = new GenericXmlApplicationContext(); 
		gctx.load("classpath:spring/conf/app-context-beanlifecycle.xml");
		gctx.refresh();
		
		gctx.getBean("Singer1");
		gctx.getBean("Singer2");
		// throws error
		try {
		gctx.getBean("Singer3");
		}catch(Exception e) {
			System.out.println("Singer3 gives error");
		}
	}

}
