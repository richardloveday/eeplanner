package com.eeplanner.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import com.eeplanner.dao.hibernate.util.DAOUtil;


/**
 * Implementation of <code>GenericDAO</code> using Hibernate.
 * The SessionFactory property is annotated for automatic resource injection.
 * 
 * @author dwolverton
 * 
 * @param <T>
 *            The type of the domain object for which this instance is to be
 *            used.
 * @param <ID>
 *            The type of the id of the domain object for which this instance is
 *            to be used.
 */
@SuppressWarnings("unchecked")
public class GenericDAOImpl<T, ID extends Serializable> extends
		HibernateBaseDAO implements GenericDAO<T, ID> {

	protected Class<T> persistentClass = (Class<T>) DAOUtil.getTypeArguments(GenericDAOImpl.class, this.getClass()).get(0);
	
	public T find(Serializable id) {
		return _get(persistentClass, id);
	}
	
	public T createQuery(String query) {
		return (T) getSession().createQuery(query);		
	}

	public T[] find(Serializable... ids) {
		return _get(persistentClass, ids);
	}

	public List<T> findAll() {
		return _all(persistentClass);
	}

	public void flush() {
		_flush();
	}

	public T getReference(Serializable id) {
		return _load(persistentClass, id);
	}

	public T[] getReferences(Serializable... ids) {
		return _load(persistentClass, ids);
	}

	public boolean isAttached(T entity) {
		return _sessionContains(entity);
	}

	public void refresh(T... entities) {
		_refresh(entities);
	}

	public boolean remove(T entity) {
		return _deleteEntity(entity);
	}

	public void remove(T... entities) {
		_deleteEntities(entities);
	}

	public boolean removeById(Serializable id) {
		return _deleteById(persistentClass, id);
	}

	public void removeByIds(Serializable... ids) {
		_deleteById(persistentClass, ids);
	}

	public boolean save(T entity) {
		return _saveOrUpdateIsNew(entity);
	}

	public boolean[] save(T... entities) {
		return _saveOrUpdateIsNew(entities);
	}
	
}