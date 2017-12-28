/**
 * 
 */
package spring.hibernate;

import java.util.List;

/**
 * @author pratik
 *
 */
public interface SingerDao {
	List<Singer> findAll();
	Singer findById(Long singerId);
	Singer save(Singer singer);
	List<Singer> findAllWithAlbum();
}
