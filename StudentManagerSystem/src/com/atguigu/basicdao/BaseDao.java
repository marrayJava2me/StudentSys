package com.atguigu.basicdao;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.atguigu.Utils.MyC3P0Utils;

public class BaseDao<T> {
	/*
	 * 通用的增删改方法
	 */
	public int uptade(String sql, Object... objects) {
		Connection connection = null;
		QueryRunner qr = new QueryRunner();
		try {
			connection = MyC3P0Utils.getConnection();
			int update = qr.update(connection, sql, objects);
			try {
				MyC3P0Utils.closeConnection(null, null, connection);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return update;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * \ 查询返回list
	 * @param sql
	 * @param clazz
	 * @param objects
	 */
	public List<T> queryAll(String sql, Class<T> clazz, Object... objects) {
		Connection connection = null;
		QueryRunner qr = new QueryRunner();
		try {
			connection = MyC3P0Utils.getConnection();
			List<T> list = qr.query(connection, sql, new BeanListHandler<T>(clazz), objects);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			MyC3P0Utils.closeConnection(null, null, connection);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * \ 查询返回单个对象
	 * 
	 * @param sql
	 * @param clazz
	 * @param objects
	 */
	public T query(String sql, Class<T> clazz, Object... objects) {
		Connection connection = null;
		QueryRunner qr = new QueryRunner();
		try {
			connection = MyC3P0Utils.getConnection();
			T t = qr.query(connection, sql, new BeanHandler<T>(clazz), objects);
			try {
				MyC3P0Utils.closeConnection(null, null, connection);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param sql
	 * @param clazz
	 * @param objects
	 * @return 返回单个值
	 */
	public Object queryValue(String sql, Class<T> clazz, Object... objects) {
		Connection connection = null;
		QueryRunner qr = new QueryRunner();
		try {
			connection = MyC3P0Utils.getConnection();
			Object object = qr.query(connection, sql, new ScalarHandler(), objects);
			try {
				MyC3P0Utils.closeConnection(null, null, connection);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return object;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
