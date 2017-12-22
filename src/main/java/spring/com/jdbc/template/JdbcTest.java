package spring.com.jdbc.template;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.com.jdbc.SingerDao;

public class JdbcTest {
	private static Logger logger = LoggerFactory.getLogger(JdbcTest.class);
	
	@Test
	public void testOne() {
		AnnotationConfigApplicationContext actx = new AnnotationConfigApplicationContext();
		actx.register(NamedDbConfig.class);
		actx.refresh();
		SingerDao singerDao = actx.getBean(SingerDao.class);
		assertNotNull(singerDao);
		test(singerDao);
		actx.close();
	}
	
	private void test(SingerDao singerDao) {
		String result = singerDao.findLastNameById(1l);
		logger.info(result);
		assert result.equals("John Mayer");
	}

}
