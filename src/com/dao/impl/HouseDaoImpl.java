package com.dao.impl;

import java.sql.SQLException;
import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.HouseDao;
import com.model.House;













public class HouseDaoImpl extends HibernateDaoSupport implements  HouseDao{


	public void deleteBean(House bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(House bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public House selectBean(String where) {
		List<House> list = this.getHibernateTemplate().find("from House " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from House "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<House> selectBeanList(final int start,final int limit,final String where) {
		return (List<House>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<House> list = session.createQuery("from House "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(House bean) {
		this.getHibernateTemplate().update(bean);
		
	}
	
	
}
