package com.dao.mysql;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;



/**
 * @DESCRIPION :	父类basedao
 * @Create on:      2016年8月24日 上午9:36:59 
 * @Author :        "luguangguang"
 * @param <T>
 */
public abstract class BaseDao<T> {
	private static Logger LOGGER = LoggerFactory
			.getLogger(BaseDao.class);
	protected Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public BaseDao() {
		entityClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Resource
	private JdbcTemplate jdbcTemplateBase;
	//@Autowired NamedParameterJdbcTemplate nameParameterJdbcTemplate;
	/**
	 * @DESCRIPION : 从数据库中获取一条记录, 实际得到对应的一个对象 
	 * 注意不是调用 queryForObject(String sql,Class<Employee> requiredType, Object... args) 方法! 
	 * 而需要调用 queryForObject(String sql, RowMapper<Employee> rowMapper,Object... args) 
	 * 1. 其中的 RowMapper 指定如何去映射结果集的行, 常用的实现类为BeanPropertyRowMapper 
	 * 2. 使用 SQL 中列的别名完成列名和类的属性名的映射. 例如last_name lastName 
	 * 3. 不支持级联属性. JdbcTemplate 到底是一个 JDBC 的小工具,而不是 ORM 框架
	 * @Create on: 2015年12月29日 下午3:11:45
	 * @Author : "luguangguang"
	 * @return : T
	 */
	public T queryForObject(final String sql,final Object... args) {
		RowMapper<T> rowMapper = new BeanPropertyRowMapper<T>(entityClass);
		try {
			return (T) jdbcTemplateBase.queryForObject(sql, rowMapper, args);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * @DESCRIPION :	查到实体类的集合
	 * 					注意调用的不是 queryForList 方法
	 * @Create on:      2015年12月29日 下午3:20:52 
	 * @Author :        "luguangguang"
	 * @return :		List<T>
	 */
	public List<T> queryForList(final String sql,final Object... args){
		RowMapper<T> rowMapper = new BeanPropertyRowMapper<T>(entityClass);
		try {
			return jdbcTemplateBase.query(sql, rowMapper,args);
		} catch (DataAccessException e) {
			return null;
		}
	}
	
	/**
	 * @DESCRIPION :	获取单个列的值, 或做统计查询
	 * 					使用 queryForObject(String sql, Class<Long> requiredType) 
	 * @Create on:      2015年12月29日 下午3:25:15 
	 * @Author :        "luguangguang"
	 * @return :		Long
	 */
	public Long queryForCount(final String sql,final Object... args){
		return jdbcTemplateBase.queryForObject(sql, Long.class,args);
	}
	
	/**
	 * @DESCRIPION : 执行 INSERT, UPDATE, DELETE
	 * @Create on: 2015年12月29日 下午2:46:39
	 * @Author : "luguangguang"
	 * @return : int
	 */
	public int update(final String sql,final Object... args) {
		int num = jdbcTemplateBase.update(sql, args);
		return num;
	}

	/**
	 * 执行批量更新: 批量的 INSERT, UPDATE, DELETE 最后一个参数是 Object[] 的 List 类型:
	 * 因为修改一条记录需要一个 Object 的数组, 那么多条不就需要多个 Object 的数组吗
	 */
	public void batchUpdate(final String sql,final List<Object[]> batchArgs) {
		try {
			jdbcTemplateBase.batchUpdate(sql, batchArgs);
		} catch (DataAccessException e) {
			LOGGER.info(e.getMessage());
		}
	}
	
	/*public int updateNamedParameter(final String sql,final T entity){
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(entity);
		return nameParameterJdbcTemplate.update(sql, paramSource);
	}*/
}
