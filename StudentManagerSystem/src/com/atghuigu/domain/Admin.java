package com.atghuigu.domain;
/**
 * 用户表的实体类
 * @author Administrator
 *
 */
public class Admin {
	private String id;
	private String uesername;
	private String password;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUesername() {
		return uesername;
	}

	public void setUesername(String uesername) {
		this.uesername = uesername;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin() {
		super();
	}

	public Admin(String uesername, String password) {
		super();
		this.uesername = uesername;
		this.password = password;
	}

	public Admin(String id, String uesername, String password) {
		super();
		this.id = id;
		this.uesername = uesername;
		this.password = password;
	}
	
}
