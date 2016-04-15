package csv.util.persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface IBaseDao {
	public void saveOrUpdate(Object obj);
	public void delete(Object obj);
	public List findByExample(Class clazz, Object obj, String[] excludedProps);
	public void attach(Object obj);
	public void attachAll(Collection col);
	public void update(Object obj);
	public void updateAll(Collection col);
	public Object merge(Object obj);
	public Object load(Class clazz, Serializable id);
	public Object get(Class clazz, Serializable id);
	public void flush();
	public Serializable save(Object obj);
	public void reconnect();
}
