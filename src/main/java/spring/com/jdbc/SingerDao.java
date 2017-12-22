package spring.com.jdbc;

import java.util.*;

public interface SingerDao {
	List<Singer> findAll();
	List<Singer> firstByFirstName();
	String findFirsttNameById(Long id);
	String findLastNameById(Long id);
	
	void insert(Singer singer);
	void update(Singer singer);
	void delete(Long singerId);
	
	List<Singer> findAllWithDetails();
	void insertWithDetail(Singer singer);
}
