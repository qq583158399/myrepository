package com.tkgl.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
/*
public class TxQueryRunner extends QueryRunner {

	@Override
	public int[] batch(String sql, Object[][] params) throws SQLException {
		Connection con=JdbcUtilss.getConnection();
		int []result=super.batch(con, sql, params);
		JdbcUtilss.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T insert(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
		Connection con=JdbcUtilss.getConnection();
		T insert=super.insert(con, sql, rsh);
		JdbcUtilss.releaseConnection(con);
		return insert;
	}

	@Override
	public <T> T insert(String sql, ResultSetHandler<T> rsh) throws SQLException {
		Connection con=JdbcUtilss.getConnection();
		T insert=super.insert(con, sql, rsh);
		JdbcUtilss.releaseConnection(con);
		return insert;
	}

	@Override
	public <T> T insertBatch(String sql, ResultSetHandler<T> rsh, Object[][] params) throws SQLException {
		Connection con=JdbcUtilss.getConnection();
		T insert=super.insert(con, sql, rsh, params);
		JdbcUtilss.releaseConnection(con);
		return insert;
	}

	@Override
	public <T> T query(String sql, Object param, ResultSetHandler<T> rsh) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=JdbcUtilss.getConnection();
		T result=super.query(con, sql, param, rsh);
		JdbcUtilss.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T query(String sql, Object[] params, ResultSetHandler<T> rsh) throws SQLException {
		Connection con=JdbcUtilss.getConnection();
		T result=super.query(con, sql, params, rsh);
		JdbcUtilss.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
		Connection con=JdbcUtilss.getConnection();
		T result=super.query(con, sql, rsh, params);
		JdbcUtilss.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
		Connection con=JdbcUtilss.getConnection();
		T result=super.query(con, sql, rsh);
		JdbcUtilss.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql, Object... params) throws SQLException {
		Connection con=JdbcUtilss.getConnection();
		int result=super.update(con, sql, params);
		JdbcUtilss.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql, Object param) throws SQLException {
		Connection con=JdbcUtilss.getConnection();
		int result=super.update(con, sql, param);
		JdbcUtilss.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql) throws SQLException {
		Connection con=JdbcUtilss.getConnection();
		int result=super.update(con, sql);
		JdbcUtilss.releaseConnection(con);
		return result;
	}

}
*/

import myutils.JdbcUtils;

/*
 * 这个类中的方法，自己来处理连接的问题，无需外界传递
 * 怎么处理的呢？
 *   通过JdbcUtilss.getConnection()得到连接！有可能是事务连接，也可能是普通连接
 *   JdbcUtilss.releaseConnection()完成对连接的释放！如果是普通连接，关闭之
 */
public class TxQueryRunner extends QueryRunner{
	public int[] batch(String sql, Object[][] params) throws SQLException {
		/*
		 * 得到连接
		 * 执行父类方法
		 * 释放连接
		 * 返回值
		 */
		Connection con=JdbcUtils.getConnection();
		int[]result=super.batch(con,sql, params);
		JdbcUtils.releaseConnection(con);
		return result;
	}
@Override
	public <T> T query(String sql, Object param, ResultSetHandler<T> rsh) throws SQLException {
		Connection con=JdbcUtils.getConnection();
		T result=super.query(con,sql, param,rsh);
		JdbcUtils.releaseConnection(con);
		return result;
	}

	
	public <T> T query(String sql, Object[] params, ResultSetHandler<T> rsh) throws SQLException {
		Connection con=JdbcUtils.getConnection();
		T result=super.query(con,sql, params,rsh);
		JdbcUtils.releaseConnection(con);
		return result;
	}


	public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
		Connection con=JdbcUtils.getConnection();
		T result=super.query(con,sql, rsh,params);
		JdbcUtils.releaseConnection(con);
		return result;
	}


	public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
		Connection con=JdbcUtils.getConnection();
		T result=super.query(con,sql, rsh);
		JdbcUtils.releaseConnection(con);
		return result;
	}

	
	public int update(String sql, Object... params) throws SQLException {
		Connection con=JdbcUtils.getConnection();
		int result=super.update(con,sql, params);
		JdbcUtils.releaseConnection(con);
		return result;
	}


	public int update(String sql, Object param) throws SQLException {
		Connection con=JdbcUtils.getConnection();
		int result=super.update(con,sql, param);
		JdbcUtils.releaseConnection(con);
		return result;
	}

	public int update(String sql) throws SQLException {
		Connection con=JdbcUtils.getConnection();
		int result=super.update(con,sql);
		JdbcUtils.releaseConnection(con);
		return result;
	}
	

}
