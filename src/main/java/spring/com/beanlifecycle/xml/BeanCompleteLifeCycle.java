package spring.com.beanlifecycle.xml;

import java.io.File;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanCompleteLifeCycle implements InitializingBean, DisposableBean{
	
	private String filePath;
	private File file;

	public void setFilePath(String loc) {
		filePath = loc;
	}
	
	public void setFile(File fl) {
		file = fl;
	}
	
	@Override
	public void destroy() throws Exception {
		// release the resource
		if(!this.file.delete()) {
			throw new Exception("Failed to delete the file");
		}
		
		System.out.println("file.exists? "+this.file.exists());
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// initialize some resource
		if(filePath == null) {
			throw new BeanCreationException("Not file path found!");
		}
		
		this.file = new File(this.filePath);
		this.file.createNewFile();
		System.out.println("file.exists? "+ this.file.exists());
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext gctx = new GenericXmlApplicationContext(); 
		gctx.load("classpath:spring/conf/app-context-completebeanlifecycle.xml");
		gctx.refresh();
		gctx.registerShutdownHook();
		
		gctx.getBean(BeanCompleteLifeCycle.class);
		
		// as registerShutdownHook has been used, no need for destroy/close 
		//gctx.destroy();
		//gctx.close();

	}

}
