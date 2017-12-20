package spring.com.aop.pointcuts;

public class Target {
	public void sing() {
		System.out.println("Inside Target");
	}
	
	public void printNumber(int arg) {
		System.out.println(arg);
	}
	
	public void printNumber(int arg, int argb) {
		System.out.println(arg);
	}
}
