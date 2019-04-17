package com.dao.impl;

import java.sql.SQLException;
import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.ZufangDao;
import com.model.Zufang;













public class ZufangDaoImpl extends HibernateDaoSupport implements  ZufangDao{


	public void deleteBean(Zufang bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(Zufang bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public Zufang selectBean(String where) {
		List<Zufang> list = this.getHibernateTemplate().find("from Zufang " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Zufang "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Zufang> selectBeanList(final int start,final int limit,final String where) {
		return (List<Zufang>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Zufang> list = session.createQuery("from Zufang "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Zufang bean) {
		this.getHibernateTemplate().update(bean);
		
	}
	
	
}
