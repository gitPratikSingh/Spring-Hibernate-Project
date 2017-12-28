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
}
