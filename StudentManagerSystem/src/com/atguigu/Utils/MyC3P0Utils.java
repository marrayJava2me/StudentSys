package com.atguigu.Utils;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 此类用于演示通过数据库连接池获取连接和关闭连接
 * @author liyuting
 *
 */
public class MyC3P0Utils {
	static ComboPooledDataSource cpds;
	static{
	// 1.创建数据库连接池对象
			 cpds = new ComboPooledDataSource("hello");
			
	}

	public static Connection getConnection() throws Exception {
		
		// 2.获取连接
		Connection connection = cpds.getConnection();
		
		return connection;
	}

	/**
	 * 关闭连接
	 * @return
	 * @throws Exception
	 */
	public static void closeConnection(Statement statement,ResultSet set,Connection connection) throws Exception{
		if(set!=null)
			set.close();
		if(statement!=null)
			statement.close();
		if(connection!=null)
			connection.close();
	}
}
