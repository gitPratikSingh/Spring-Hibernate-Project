package spring.hibernate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class HiberbateTest {
	
	private static Logger logger = LoggerFactory.getLogger(HiberbateTest.class);
	
	public static void main(String[] args) {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		SingerDao singerDao = ctx.getBean(SingerDao.class);
		//listSingers(singerDao.findAll());
		
		Singer s = singerDao.findById(1L);
		System.out.println(s.getFirst_name() + " "+ s.getLast_name());
		ctx.close();
	}

	private static void listSingers(List<Singer> singers) {
		logger.info("listing singers: ... ");
		for(Singer s: singers) {
			logger.info(s.toString());
		} 
	}

}
