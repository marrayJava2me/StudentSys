package com.atguigu.service;

import java.util.List;

import com.atghuigu.domain.Student;
import com.atguigu.Utils.MyC3P0Utils;
import com.atguigu.basicdao.StudentDao;

public class StudentService {
	StudentDao sd = new StudentDao();

	/**
	 * ͳ��ѧ�������ķ���
	 */
	public Object StuCounts() {
		String sql = "select count(*) from student";
		Object value = sd.queryValue(sql, Student.class);

		return value;
	}

	/**
	 * ��������ѧ������
	 * 
	 * @return list����
	 */
	public List<Student> ListStu() {
		String sql = "select * from student";
		List<Student> list = sd.queryAll(sql, Student.class);
		return list;
	}

	/**
	 * ����ѧ��id��ѯѧ��������
	 * 
	 * @param id
	 * @return
	 */
	public Object getStuNameAsId(String id) {
		String sql = "select name from student where id=?";
		Object value = sd.queryValue(sql, Student.class, id);
		return value;
	}

	/**
	 * ����ѧ��������������ʹ�ؼ��֣���ѯѧ����Ϣ
	 * 
	 * @param name
	 * @return ����ѧ��������ƥ��Ķ���
	 */
	public List<Student> getStuInfoAsName(String name) {
		String sql = "select * from student where name like ?";
		List<Student> list = sd.queryAll(sql, Student.class, "%" + name + "%");
		return list;
	}

	/**
	 * ����id�޸�ѧ��������
	 * 
	 * @param birth
	 * @param id
	 * @return ������Ӱ�������int
	 */
	public int updateBirthdayAsId(String birth, String id) {
		int uptade = sd.uptade("update student set birth=? where id=? ", birth, id);
		return uptade;
	}

	/**
	 * \ ����ѧ��idɾ��ѧ����¼
	 * 
	 * @param id
	 * @return
	 */
	public int deleteStu(String id) {
		int uptade = sd.uptade("delete from student where id=?", id);
		return uptade;

	}

}
