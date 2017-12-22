package spring.com.jdbc;

import java.sql.Driver;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class DbConfig {
	
	private static Logger logger = LoggerFactory.getLogger(DbConfig.class);
	
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.userName}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	
	@Bean
	@Lazy
	public DataSource datasource() {
		SimpleDriverDataSource datasource = new SimpleDriverDataSource();
		try {
			Class<? extends Driver> driver = (Class<? extends Driver>) Class.forName(driverClassName);
			datasource.setDriverClass(driver);
			datasource.setUrl(url);
			datasource.setPassword(password);
			datasource.setUsername(username);
		}catch (Exception e) {
			logger.error("Error in setting DB config", e);
		}
		
		return datasource;
	}
	
}
