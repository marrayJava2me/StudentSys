package com.atguigu.service;

import com.atghuigu.domain.Admin;
import com.atguigu.basicdao.AdminDao;

public class AdminService {
	AdminDao ad=new AdminDao();
	/**
	 * ͨ���û��������ѯ���е�¼
	 * @param username
	 * @param password
	 * @return ����Admin����
	 */
	public Admin login(String username,String password){
		Admin admin = ad.query("select * from admin where username=? and password=?", Admin.class, username,password);
		return admin;
		
	}
}
