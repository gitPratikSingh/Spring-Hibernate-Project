package spring.org;

public class StandardLookupBean {
	private Singer mySinger;
	
	public void setMySinger(Singer s) {
		this.mySinger = s;
	}
	
	public Singer getMySinger() {
		return this.mySinger;
	}
}
