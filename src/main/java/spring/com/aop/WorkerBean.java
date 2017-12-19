package spring.com.aop;

public class WorkerBean {
	public void doSomeWork(int iterations) {
		for(int i=0; i<iterations; i++) {
			doWork();
		}
	}

	public void doWork() {
		System.out.print("");
	}
}
