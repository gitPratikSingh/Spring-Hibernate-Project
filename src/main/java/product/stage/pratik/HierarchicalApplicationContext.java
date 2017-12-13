package product.stage.pratik;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HierarchicalApplicationContext {

	public static void main(String[] args) {
		
		
		GenericXmlApplicationContext parent = new GenericXmlApplicationContext();
		parent.load("classpath:spring/app-context-parent.xml");
		parent.refresh();
		
		GenericXmlApplicationContext child = new GenericXmlApplicationContext();
		child.load("classpath:spring/app-context-child.xml");
		child.setParent(parent);
		child.refresh();
		
		Song s1 = child.getBean("song1", Song.class);
		Song s2 = child.getBean("song2", Song.class);
		Song s3 = child.getBean("song3", Song.class);

		System.out.println(s1.getTitle());
		System.out.println(s2.getTitle());
		System.out.println(s3.getTitle());
		
	}

}
