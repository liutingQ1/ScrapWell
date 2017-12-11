package com.changqin.well.dao.Impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.changqin.well.dao.BaseDAO;
 
@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED, 
rollbackFor=Exception.class,readOnly=false)
public class BaseDAOImpl<T> implements BaseDAO<T> {

    private Class<T> entityClazz;
    private String entityName;
    private String idName;

    @Autowired
    private SessionFactory sessionFactory;

    public BaseDAOImpl() { 
        Type type = getClass().getGenericSuperclass(); 
        if (type instanceof ParameterizedType) { 
            this.entityClazz = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0]; 
            entityName = entityClazz.getSimpleName();
            Field[] fields = entityClazz.getDeclaredFields();
            if(fields.length>0){
                idName = fields[0].getName();
            }
        } else { 
            this.entityClazz = null; 
        }
    } 
    @Override
    public void save(Object entity) {
        getSession().save(entity);
    }
    @Override
    public void saveAll(List<T> entity) {
        Session session = getSession();
        for (T t : entity) {
            session.save(t);
        }
    }
    @Override
    public void saveAll(Collection<T> entity) {
        Session session = getSession();
        for (T t : entity) {
            session.save(t);
        }
    }
    @Override
    public void delete(Object entity) {
        getSession().delete(entity);
    }

    @Override
    public void update(Object entity) {
        getSession().update(entity);
    }
    @Override
    public T selectOneById(Integer id) {

        String sql = "from "+ entityName +" where "+ idName +" = ?";
        Query query = getSession().createQuery(sql);
        query.setInteger(0, id);
        Object result = query.uniqueResult();
        return (T)result;
    }
    @Override
    public List<T> selectAll() {
        String sql = "from "+ entityName +" order by "+idName;
        Query query = getSession().createQuery(sql);
        List<T> list = query.list();
        return list;
    }
    
    public Session getSession() {  
        Session session = sessionFactory.getCurrentSession();  
        return session;  
    }
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}  
}
