package spring.com.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestConnection {

	private static final Logger logger = LoggerFactory.getLogger(TestConnection.class);
	
	@Test
	public void test() throws SQLException {
		GenericXmlApplicationContext gctx = new GenericXmlApplicationContext();
		gctx.load("classpath:spring/conf/app-context-jdbc.xml");
		gctx.refresh();
		
		DataSource dataSource = gctx.getBean("datasource", DataSource.class);
		dataSource.getConnection();
		assertNotNull(dataSource);
		testDataSource(dataSource);
		
		AnnotationConfigApplicationContext actx = new AnnotationConfigApplicationContext();
		actx.register(DbConfig.class);
		actx.refresh();
		
		dataSource = actx.getBean("datasource", DataSource.class);
		assertNotNull(dataSource);
		testDataSource(dataSource);
		
		gctx.close();
	}

	private static void testDataSource(DataSource dataSource) throws SQLException {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement =
			connection.prepareStatement("SELECT 1");
			ResultSet resultSet = statement.executeQuery();
			
				while (resultSet.next()) {
					int mockVal = resultSet.getInt(1);
					assertTrue(mockVal== 1);
				}
			statement.close();
		} catch (Exception e) {
			logger.debug("Something unexpected happened.", e);
		} finally {
		
			if (connection != null) {
					connection.close();
			}
		}
	}
}

