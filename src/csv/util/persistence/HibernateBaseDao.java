package csv.util.persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.StaleStateException;
import org.hibernate.criterion.Example;
import org.hibernate.exception.ConstraintViolationException;

public abstract class HibernateBaseDao implements IBaseDao {
	
	public abstract Session getSession();
	public abstract void setSession(Session session);
		
	public void saveOrUpdate(Object entity) {
		try {
			getSession().saveOrUpdate(entity);
		} catch(HibernateException e) {
			handleException(e);
		}
	}
	
	public void delete(Object entity) {
		try {
			getSession().delete(entity);
		} catch(HibernateException e) {
			handleException(e);
		}
	}
	
	public List findByExample(Class clazz, Object entity, String[] excludedProps) {
		try {
			Criteria crit = getSession().createCriteria(clazz);
			Example example =  Example.create(entity);
			for (String exclude : excludedProps) {
				example.excludeProperty(exclude);
			}
			crit.add(example);
			return crit.list();
		} catch(HibernateException e) {
			handleException(e);
		}
		return null;
	}
	
	public void attach(Object entity) {
		try {
			getSession().lock(entity, LockMode.READ);
		} catch(HibernateException e) {
			handleException(e);
		}
	}
	
	public void attachAll(Collection col) {
		try {
			for(Object entity : col)
			getSession().lock(entity, LockMode.READ);
		} catch(HibernateException e) {
			handleException(e);
		}
	}
	
	public void update(Object entity) {
		try {
			getSession().update(entity);
		} catch(HibernateException e) {
			handleException(e);
		}
	}
	
	public void updateAll(Collection col) {
		try {
			for(Object entity : col)
			getSession().update(entity);
		} catch(HibernateException e) {
			handleException(e);
		}
	}
	
	public Object merge(Object entity) {
		try {
			return getSession().merge(entity);
		} catch(HibernateException e) {
			handleException(e);
		}
		return null;
	}
	
	public Object load(Class clazz, Serializable id) {
		try {
			return getSession().load(clazz, id);
		} catch(HibernateException e) {
			handleException(e);
		}
		return null;
	}
	
	public Object get(Class clazz, Serializable id) {
		try {
			return getSession().get(clazz, id);
		} catch(HibernateException e) {
			handleException(e);
		}
		return null;
	}
	
	public void flush() {
		try {
			getSession().flush();
		} catch(HibernateException e) {
			handleException(e);
		}
	}
	
	public Serializable save(Object entity) {
		try {
			return getSession().save(entity);
		} catch(HibernateException e) {
			handleException(e);
		}
		return null;
	}
	
	public void reconnect() {
		try {
			getSession().reconnect();
		} catch(HibernateException e) {
			handleException(e);
		}
	}
	
	public void handleException(HibernateException e) {
		if(e instanceof StaleStateException) {
			throw new RuntimeException("The record you have been working with was updated or deleted by somebody else: " + e.getMessage());
		} if(e instanceof NonUniqueResultException) {
			throw new RuntimeException("More than one record has been found for an entity which must be unique in the system. Please contact your system support: " + e.getMessage());
		} if(e instanceof ConstraintViolationException) {
			throw new RuntimeException("The operation you have attempted results in a constraint violation: " + ((ConstraintViolationException)e).getConstraintName());
		} else {
			throw e;
		}
	}
	
}
