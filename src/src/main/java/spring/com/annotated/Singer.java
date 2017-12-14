package spring.com.annotated;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//non-singleton class
@Component("singer")
@Scope("prototype")
public class Singer {
	private String lyric="Aye dil hain..yaha!";
	
	public void sing() {
		System.out.println(lyric);
	}
}
