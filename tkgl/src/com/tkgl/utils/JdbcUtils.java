package com.tkgl.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//支持事务,以及多线程并发访问
public class JdbcUtils {
    //创建
    private  static ComboPooledDataSource dataSource=new ComboPooledDataSource();
    //用于专门处理事务的连接
    private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
    //获取连接
    public static Connection getConnection() throws SQLException{
    	      Connection con=tl.get();
    	      //如果con不为空,返回的是con 
    	      if(con!=null) return con;
    	      //如果为空就返回一个数据库连接池里的con
    	       return dataSource.getConnection();
    
    }
    
    //获取数据库连接池
    public static ComboPooledDataSource getComboPooledDataSource(){
    	
    	       return dataSource;
    }
   
    //事物的开启    
    public static void beginTransaction() throws SQLException{
    	Connection con=tl.get();
    	if(con!=null)   throw new SQLException("你已经开启事务了");
    	con=getConnection();
    	con.setAutoCommit(false);
    	tl.set(con);
    }
   
    //事物的结束    
    public static void commitTransaction() throws SQLException{
    	Connection con=tl.get();
    	if(con==null) throw new SQLException("你还没有开启事务");
    	con.commit();
    	con.close();
    	tl.remove();
    }
    
    //事物的回滚
    public static void rollbackTransaction() throws SQLException{
    	Connection con=tl.get();
    	if(con!=null)  throw new SQLException("你还没有开启事务");
    	con.rollback();
    	con.close();
    	tl.set(con);
    }
    
    public static void releaseConnection(Connection connection) throws SQLException{
    	//判断是否是事务专用,如果不是,将其关闭
    	Connection con=tl.get();
    	if(con==null) connection.close();
    	if(con!=connection) connection.close();
    }
}
