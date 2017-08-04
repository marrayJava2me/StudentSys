package com.atguigu.service;

import com.atghuigu.domain.Admin;
import com.atguigu.basicdao.AdminDao;

public class AdminService {
	AdminDao ad=new AdminDao();
	/**
	 * 通过用户名密码查询进行登录
	 * @param username
	 * @param password
	 * @return 返回Admin对象
	 */
	public Admin login(String username,String password){
		Admin admin = ad.query("select * from admin where username=? and password=?", Admin.class, username,password);
		return admin;
		
	}
}
