package spring.com.jdbc.template;

import java.util.List;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import spring.com.jdbc.Singer;
import spring.com.jdbc.SingerDao;

public class JdbcSingerDao implements SingerDao, InitializingBean {
	
	JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Singer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Singer> firstByFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findFirsttNameById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findLastNameById(Long id) {
		
		return jdbcTemplate.queryForObject("Select first_name || ' ' || last_name from \"MusicSchema\".\"Singer\" Where id = ?", 
				new Object[] {id}, String.class);
		
	}

	@Override
	public void insert(Singer singer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Singer singer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long singerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Singer> findAllWithDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertWithDetail(Singer singer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
		if(jdbcTemplate == null) {
			throw new BeanCreationException("jdbcSingerDao not set!");
		}
		
	}

}
