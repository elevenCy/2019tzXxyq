package com.winter.mapper;

import com.winter.common.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface BaseDao<T> {
	/**
	 * 保存一个对象
	 * @param o 对象
	 * @return 对象的ID
	 */
	public void insert(T o);
	/**
	 * 保存一组对象
	 * @param os 对象
	 * @return 对象的ID
	 */
	public void insertBatch(List<T> os);
	/**
	 * 删除一个对象
	 * @param o  对象
	 */
	public void delete(T o);
	/**
	 * 更新一个对象
	 * @param o 对象       
	 */
	public void update(T o);
	/**
	 * 批量删除一组对象
	 * @param os (主键)数组
	 */
	public void deleteBatch(List<T> os);
	/**
	 * 获得对象列表
	 * @param o 对象       
	 * @return List
	 */
	public List<T> find(T o);	
	/**
	 * 获得对象列表
	 * @param o 对象       
	 * @param page 分页对象
	 * @return List
	 */
	public List<T> findByPage(@Param("param") T o, Page<T> page);
	/**
	 * 统计数目
	 * @param o 对象
	 * @return long
	 */
	public int count(T o);

	/**
	 * 根据sql查询列表
	 * @param sql SQL语句
	 * @return 集合List
	 */
	public List<T> findBySql(@Param("sql") String sql);

	/**
	 * 根据sql查询对象
	 * @param sql SQL语句
	 * @return 对象
	 */
	public T findObjBySql(@Param("sql") String sql);

	/**
	 * 根据sql修改
	 * @param sql SQL语句
	 * @return 影响条数
	 */
	public Integer updateBySql(@Param(value = "sql") String sql);
}
