package spring.com.jdbc;

import java.util.*;

public interface SingerDao {
	List<Singer> findAll();
	List<Singer> firstByFirstName();
	String findFirsttNameById(String firstName);
	String findLastNameById(String lastName);
	
	void insert(Singer singer);
	void update(Singer singer);
	void delete(Long singerId);
	
	List<Singer> findAllWithDetails();
	void insertWithDetail(Singer singer);
}
