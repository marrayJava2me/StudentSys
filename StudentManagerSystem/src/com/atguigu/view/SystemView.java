package com.atguigu.view;

import java.util.List;
import java.util.Scanner;

import com.atghuigu.domain.Admin;
import com.atghuigu.domain.Student;
import com.atguigu.Utils.TSUtility;
import com.atguigu.service.AdminService;
import com.atguigu.service.StudentService;

public class SystemView {
	public static void main(String[] args) {
		SystemView sv=new SystemView();
		sv.menu();
		
	}
	Scanner sc=new Scanner(System.in);
	StudentService ss=new StudentService();
	AdminService as=new AdminService();
	boolean boo=true;
	public void menu(){
		while(true){
		boolean login = login();
		if(login)
			break;
		else
			System.out.println("登录失败，请重新输入！");
		}
		while(boo){
			System.out.println("-------请选择操作键-------");
			System.out.println("1、统计学生人数");
			System.out.println("2、查看学生名单");
			System.out.println("3、按学号查询学生姓名");
			System.out.println("4、按姓名查询学生信息");
			System.out.println("5、修改学生出生日期");
			System.out.println("6、删除学生记录");
			System.out.println("7、新增年级记录");
			System.out.println("0、退出");
			System.out.println("-----------------------");
			char choice = TSUtility.readMenuSelection();
			switch(choice){
				case '1':
					countStuNumber();
					break;
				case '2':
					listStudent();
					break;
				case '3':
					StuName();
					break;
				case '4':
					StuInfo();
					break;
				case '5':
					updateBirth();
					break;
				case '6':
					delete();
					break;
				case '0':
					boo=false;
			}
		}
	}
	/**
	 * 登录界面
	 */
	public boolean login(){
		System.out.println("请输入用户名：");
		String username = sc.next();
		System.out.println("请输入密码：");
		String password = sc.next();
		Admin admin = as.login(username, password);
		if(admin!=null){
			System.out.println("登陆成功！");
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 1.查询当前学生人数
	 */
	public void countStuNumber(){
		Object counts = ss.StuCounts();
		System.out.println("当前有"+counts+"人");
	}
	/**
	 * 查看学生名单
	 */
	public void listStudent(){
		System.out.println("-----------------");
		System.out.println("学号\t姓名");
		System.out.println("-----------------");
		List<Student> listStu = ss.ListStu();
		for (Student student : listStu) {
			System.out.println(student.getInfo());
		}
	}
	/**
	 * 根据输入的id查询学生姓名
	 */
	public void StuName(){
		System.out.println("请输入学生的学号：");
		String id = sc.next();
		Object Stuname = ss.getStuNameAsId(id);
		System.out.println("学号是"+id+"的学生姓名为："+Stuname);
	}
	/**
	 * 按姓名查询学生信息
	 */
	public void StuInfo(){
		System.out.println("请输入学生姓名：");
		String name = sc.next();
		System.out.println("学号\t姓名\t性别\t年级\t联系电话\t地址\t出生日期\t\t邮箱");
		List<Student> stuInfoAsName = ss.getStuInfoAsName(name);
		for (Student student : stuInfoAsName) {
			System.out.println(student);
		}
	}
	/**
	 * 根据id修改生日
	 */
	public void updateBirth(){
		System.out.println("请输入学号：");
		String id = sc.next();
		System.out.println("请输入修改过的生日（XXXX-XX-XX）：");
		String birthday = sc.next();
		int update = ss.updateBirthdayAsId(birthday, id);
		if(update>0)
			System.out.println("修改成功！");
		else
			System.out.println("修改失败！");
	}
	/**\
	 * 删除学生记录
	 */
	public void delete(){
		System.out.println("请输入学号：");
		String id = sc.next();
		Object name = ss.getStuNameAsId(id);
		System.out.println("确定要删除学号是"+id+",姓名是"+name+"的学生记录吗？（Y/N）");
		char selection = TSUtility.readConfirmSelection();
		
		if(selection=='Y'){
			ss.deleteStu(id);
			System.out.println("删除成功！");
		}else if(selection=='N')
			System.out.println("删除失败");
	}
	
	
	
}
