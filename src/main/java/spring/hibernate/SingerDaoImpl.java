package spring.hibernate;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("singerDao")

public class SingerDaoImpl implements SingerDao {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Singer> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Singer s").list();
	}

	@Override
	@Transactional(readOnly=true)
	public Singer findById(Long singerId) {
		
		return (Singer) sessionFactory.getCurrentSession()
				.getNamedQuery("Singer.findById").setParameter("Id", singerId)
				.uniqueResult();
	}

	@Override
	public Singer save(Singer singer) {
		sessionFactory.getCurrentSession().saveOrUpdate(singer);
		return singer;
	}

	@Override
	public List<Singer> findAllWithAlbum() {
		return sessionFactory.getCurrentSession().getNamedQuery("Singer.findAllWithAlbum").list();
	}
}
