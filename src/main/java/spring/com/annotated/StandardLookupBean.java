package spring.com.annotated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("standardLBean")
public class StandardLookupBean {
	private Singer mySinger;
	@Autowired
	public void setMySinger(Singer s) {
		this.mySinger = s;
	}
	
	public Singer getMySinger() {
		return this.mySinger;
	}
}
