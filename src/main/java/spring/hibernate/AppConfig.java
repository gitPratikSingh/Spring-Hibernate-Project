package spring.hibernate;

import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="spring.hibernate")
@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")
public class AppConfig {
	
	private static Logger logger = LoggerFactory.getLogger(AppConfig.class);
	
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
	
	Properties hibernateProperties() {
		Properties hibernateProp = new Properties();
		hibernateProp.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		hibernateProp.put("hibernate.format_sql", true);
		hibernateProp.put("hibernate.use_sql_comments", true);
		hibernateProp.put("hibernate.show_sql", true);
		hibernateProp.put("hibernate.max_fetch_depth", 3);
		hibernateProp.put("hibernate.jdbc.batch_size", 10);
		hibernateProp.put("hibernate.jdbc.fetch_size", 50);
		return hibernateProp;
	}
	
	@Bean
	public SessionFactory sessionFactory() throws IOException {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();	
		sessionFactoryBean.setDataSource(datasource());
		sessionFactoryBean.setPackagesToScan(
		        new String[] { "spring.hibernate" });
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		sessionFactoryBean.afterPropertiesSet();
		return sessionFactoryBean.getObject();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() throws IOException {
		return new HibernateTransactionManager(sessionFactory());
	}

}
