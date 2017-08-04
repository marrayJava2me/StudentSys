package com.atghuigu.domain;
/**\
 * 学生表的实体类
 * @author Administrator
 *
 */
public class Student {
	private String id;
	private String name;
	private String sex;
	private int grade;
	private String phone;
	private String adress;
	private String birth;
	private String email;
	public String getInfo(){
		return id+"\t"+name;
	}
	@Override
	public String toString() {
		return id+"\t"+name+"\t"+sex+"\t"+grade+"\t"+phone+"\t"+adress+
				"\t"+birth+"\t"+email;
	}
	public Student() {
		super();
	}
	public Student(String id, String name, String sex, int grade, String phone, String adress, String birth,
			String email) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.grade = grade;
		this.phone = phone;
		this.adress = adress;
		this.birth = birth;
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getgrade() {
		return grade;
	}
	public void setgrade(int grade) {
		this.grade = grade;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
