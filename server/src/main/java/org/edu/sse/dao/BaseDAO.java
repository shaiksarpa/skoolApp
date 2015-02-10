package org.edu.sse.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDAO<T extends Serializable> {
	
	protected Class<T> domainClass = getDomainClass();

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Method to return the class of the domain object
	 */
	protected abstract Class<T> getDomainClass();

	@SuppressWarnings("unchecked")
	public T get(Long id) {
		return (T) getSessionFactory().getCurrentSession().get(domainClass, id);
	}

	public void update(T t) {
		getSessionFactory().getCurrentSession().update(t);
	}

	public void save(T t) {
		getSessionFactory().getCurrentSession().save(t);
	}

	public void saveOrUpdate(T t) {
		getSessionFactory().getCurrentSession().saveOrUpdate(t);
	}

	public void delete(T t) {
		getSessionFactory().getCurrentSession().delete(t);
	}

	@SuppressWarnings("unchecked")
	public List<T> getList() {
		return (getSessionFactory().getCurrentSession().createQuery("from " + domainClass.getName()).list());
	}

	public void deleteById(Long id) {
		Object obj = get(id);
		getSessionFactory().getCurrentSession().delete(obj);
	}

	public int count() {
		List<T> list = getList();
		Integer count = list.size();
		return count.intValue();
	}
}
