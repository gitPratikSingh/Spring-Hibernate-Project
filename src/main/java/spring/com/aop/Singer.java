package spring.com.aop;

public class Singer {
	public void sing() {
		System.out.println("Inside Sing method");
	}
	
	public void sing(int x) {
		System.out.println("Inside Sing(int x) method: x="+ x);
	}
	
	public void rest() {
		System.out.println("Inside rest method");
	}
}
