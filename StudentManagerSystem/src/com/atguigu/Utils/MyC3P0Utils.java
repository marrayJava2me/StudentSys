package com.atguigu.Utils;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * ����������ʾͨ�����ݿ����ӳػ�ȡ���Ӻ͹ر�����
 * @author liyuting
 *
 */
public class MyC3P0Utils {
	static ComboPooledDataSource cpds;
	static{
	// 1.�������ݿ����ӳض���
			 cpds = new ComboPooledDataSource("hello");
			
	}

	public static Connection getConnection() throws Exception {
		
		// 2.��ȡ����
		Connection connection = cpds.getConnection();
		
		return connection;
	}

	/**
	 * �ر�����
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
