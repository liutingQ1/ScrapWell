package com.changqin.well.dao;
import java.util.Collection;
import java.util.List;
public interface BaseDAO<T> {
    /** 
     * 保存实体 
     * @param entity 
     *            实体对象 
     * @return 实体主键 
     */ 
    void save(Object entity); 
    /** 
     * 保存实体 
     * @param entity 
     *            实体对象 
     * @return 实体主键 
     */ 
    void saveAll(List<T> entity); 
   
    /** 
     * 保存实体 
     * @param entity 
     *            实体对象 
     * @return 实体主键 
     */ 
    void saveAll(Collection<T> entity);
 
    /** 
     * 删除实体 
     * @param entity 
     *            实体对象 
     */ 
    void delete(Object entity);
    /** 
     * 更新实体 
     * @param entity 
     *            实体对象 
     */ 
    void update(Object entity); 
 
    /**
     * 查询一个
     * @param id
     * @return实体对象 
     */
    T selectOneById(Integer id);
    /**
     * 查所有
     * @return实体集合
     */
    List<T> selectAll();
}
