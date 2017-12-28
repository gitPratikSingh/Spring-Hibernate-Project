
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import spring.hibernate.Album;
import spring.hibernate.AppConfig;
import spring.hibernate.Singer;
import spring.hibernate.SingerDao;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SingerDaoTest {
	private static Logger logger =LoggerFactory.getLogger(SingerDaoTest.class);
	private GenericApplicationContext ctx;
	private SingerDao singerDao;
	@Before
		public void setUp(){
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		singerDao = ctx.getBean(SingerDao.class);
		assertNotNull(singerDao);
	}
	
	@Test
	public void testInsert(){
		Singer singer = new Singer();
		singer.setFirst_name("BB");
		singer.setLast_name("King");
		singer.setBirth_date(new Date(
		(new GregorianCalendar(1940, 8, 16)).getTime().getTime()));

		Album album = new Album();
		album.setTitle("My Kind of Blues");
		album.setRelease_date(new java.sql.Date(
		(new GregorianCalendar(1961, 7, 18)).getTime().getTime()));
		singer.addAbum(album);
		album.setSinger(singer);
		
		album = new Album();
		album.setTitle("A Heart Full of Blues");
		album.setRelease_date(new java.sql.Date(
		(new GregorianCalendar(1962, 3, 20)).getTime().getTime()));
		singer.addAbum(album);
		album.setSinger(singer);
		
		singerDao.save(singer);
		assertNotNull(singer.getId());
		List<Singer> singers = singerDao.findAllWithAlbum();
		assertEquals(5, singers.size());
	}
	
	@Test
	public void testUpdate(){
		Singer singer = singerDao.findById(8L);
		
		Album album = singer.getAlbums().iterator().next();
		album.setTitle("new Title: "+ album.getTitle());
		singer.setFirst_name("new Name: "+singer.getFirst_name());
		
		singerDao.save(singer);
		assertNotNull(singer.getId());
		
	}
	
	@After
	public void tearDown(){
		ctx.close();
	}

}
