package spring.com.jdbc.template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import spring.com.jdbc.Singer;
import spring.com.jdbc.SingerDao;

public class NamedJdbcSingerDao implements SingerDao, InitializingBean {
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
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
		String sql = "Select first_name || ' ' || last_name from \"MusicSchema\".\"Singer\" Where id = :singerId";
		Map<String, Object> namedParameters = new HashMap<>();
		namedParameters.put("singerId", id);
		return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);
		
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
		
		if(namedParameterJdbcTemplate == null) {
			throw new BeanCreationException("namedParameterJdbcTemplate not set!");
		}
		
	}

	

}
