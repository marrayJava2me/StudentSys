package com.atguigu.service;

import java.util.List;

import com.atghuigu.domain.Student;
import com.atguigu.Utils.MyC3P0Utils;
import com.atguigu.basicdao.StudentDao;

public class StudentService {
	StudentDao sd = new StudentDao();

	/**
	 * 统计学生人数的方法
	 */
	public Object StuCounts() {
		String sql = "select count(*) from student";
		Object value = sd.queryValue(sql, Student.class);

		return value;
	}

	/**
	 * 返回所有学生对象
	 * 
	 * @return list集合
	 */
	public List<Student> ListStu() {
		String sql = "select * from student";
		List<Student> list = sd.queryAll(sql, Student.class);
		return list;
	}

	/**
	 * 根据学生id查询学生的姓名
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
	 * 根据学生的姓名（可以使关键字）查询学生信息
	 * 
	 * @param name
	 * @return 返回学生姓名相匹配的对象
	 */
	public List<Student> getStuInfoAsName(String name) {
		String sql = "select * from student where name like ?";
		List<Student> list = sd.queryAll(sql, Student.class, "%" + name + "%");
		return list;
	}

	/**
	 * 根据id修改学生的生日
	 * 
	 * @param birth
	 * @param id
	 * @return 返回受影响的行数int
	 */
	public int updateBirthdayAsId(String birth, String id) {
		int uptade = sd.uptade("update student set birth=? where id=? ", birth, id);
		return uptade;
	}

	/**
	 * \ 根据学生id删除学生记录
	 * 
	 * @param id
	 * @return
	 */
	public int deleteStu(String id) {
		int uptade = sd.uptade("delete from student where id=?", id);
		return uptade;

	}

}
