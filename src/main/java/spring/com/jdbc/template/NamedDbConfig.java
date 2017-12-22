package spring.com.jdbc.template;

import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.apache.commons.dbcp.BasicDataSource;
import spring.com.jdbc.SingerDao;

@Configuration
@ComponentScan("spring.com.jdbc.template") 
@PropertySource("classpath:jdbc.properties")
public class NamedDbConfig {
	
	private static Logger logger = LoggerFactory.getLogger(NamedDbConfig.class);
	
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
		BasicDataSource datasource = new BasicDataSource();
		try {
			datasource.setDriverClassName(driverClassName);
			datasource.setUrl(url);
			datasource.setPassword(password);
			datasource.setUsername(username);
		}catch (Exception e) {
			logger.error("Error in setting DB config", e);
		}
		
		return datasource;
	}
	
	@Bean
	public NamedParameterJdbcTemplate jdbcTemplate() {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate =  new NamedParameterJdbcTemplate(datasource());
		return namedParameterJdbcTemplate;
	}
	
	@Bean
	public SingerDao singerDao() {
		NamedJdbcSingerDao dao = new NamedJdbcSingerDao();
		dao.setNamedParameterJdbcTemplate(jdbcTemplate());
		return dao;
	}
	
}
