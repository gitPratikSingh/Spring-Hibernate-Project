package spring.com.aop.before;

public class SecurityManager {
	private static ThreadLocal<UserInfo> threadLocal;
	
	static{
		threadLocal = new ThreadLocal<>();
	}
	
	public void login(String uName, String uPass) {
		threadLocal.set(new UserInfo(uName, uPass));
	}
	
	public UserInfo getLoggedOnUser() {
		return threadLocal.get();
	}

	public void logout() {
		threadLocal.set(null);
	}
}
