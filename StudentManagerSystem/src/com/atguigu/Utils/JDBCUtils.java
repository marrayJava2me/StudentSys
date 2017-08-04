package com.atguigu.Utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
	static String url;
	static String driverName;
	static String user;
	static String password;
	static{
		
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream("src/db.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		url =pro.getProperty("url");
		driverName =pro.getProperty("driverName");
		user =pro.getProperty("user");
		password =pro.getProperty("password");
		//加载驱动
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 获取连接
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception{
		return DriverManager.getConnection(url, user, password);
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
