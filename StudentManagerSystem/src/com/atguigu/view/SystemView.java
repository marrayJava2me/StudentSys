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
			System.out.println("��¼ʧ�ܣ����������룡");
		}
		while(boo){
			System.out.println("-------��ѡ�������-------");
			System.out.println("1��ͳ��ѧ������");
			System.out.println("2���鿴ѧ������");
			System.out.println("3����ѧ�Ų�ѯѧ������");
			System.out.println("4����������ѯѧ����Ϣ");
			System.out.println("5���޸�ѧ����������");
			System.out.println("6��ɾ��ѧ����¼");
			System.out.println("7�������꼶��¼");
			System.out.println("0���˳�");
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
	 * ��¼����
	 */
	public boolean login(){
		System.out.println("�������û�����");
		String username = sc.next();
		System.out.println("���������룺");
		String password = sc.next();
		Admin admin = as.login(username, password);
		if(admin!=null){
			System.out.println("��½�ɹ���");
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 1.��ѯ��ǰѧ������
	 */
	public void countStuNumber(){
		Object counts = ss.StuCounts();
		System.out.println("��ǰ��"+counts+"��");
	}
	/**
	 * �鿴ѧ������
	 */
	public void listStudent(){
		System.out.println("-----------------");
		System.out.println("ѧ��\t����");
		System.out.println("-----------------");
		List<Student> listStu = ss.ListStu();
		for (Student student : listStu) {
			System.out.println(student.getInfo());
		}
	}
	/**
	 * ���������id��ѯѧ������
	 */
	public void StuName(){
		System.out.println("������ѧ����ѧ�ţ�");
		String id = sc.next();
		Object Stuname = ss.getStuNameAsId(id);
		System.out.println("ѧ����"+id+"��ѧ������Ϊ��"+Stuname);
	}
	/**
	 * ��������ѯѧ����Ϣ
	 */
	public void StuInfo(){
		System.out.println("������ѧ��������");
		String name = sc.next();
		System.out.println("ѧ��\t����\t�Ա�\t�꼶\t��ϵ�绰\t��ַ\t��������\t\t����");
		List<Student> stuInfoAsName = ss.getStuInfoAsName(name);
		for (Student student : stuInfoAsName) {
			System.out.println(student);
		}
	}
	/**
	 * ����id�޸�����
	 */
	public void updateBirth(){
		System.out.println("������ѧ�ţ�");
		String id = sc.next();
		System.out.println("�������޸Ĺ������գ�XXXX-XX-XX����");
		String birthday = sc.next();
		int update = ss.updateBirthdayAsId(birthday, id);
		if(update>0)
			System.out.println("�޸ĳɹ���");
		else
			System.out.println("�޸�ʧ�ܣ�");
	}
	/**\
	 * ɾ��ѧ����¼
	 */
	public void delete(){
		System.out.println("������ѧ�ţ�");
		String id = sc.next();
		Object name = ss.getStuNameAsId(id);
		System.out.println("ȷ��Ҫɾ��ѧ����"+id+",������"+name+"��ѧ����¼�𣿣�Y/N��");
		char selection = TSUtility.readConfirmSelection();
		
		if(selection=='Y'){
			ss.deleteStu(id);
			System.out.println("ɾ���ɹ���");
		}else if(selection=='N')
			System.out.println("ɾ��ʧ��");
	}
	
	
	
}
