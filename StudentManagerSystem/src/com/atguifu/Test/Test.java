package com.atguifu.Test;

import java.util.List;

import com.atghuigu.domain.Student;
import com.atguigu.service.StudentService;

public class Test {
	public static void main(String[] args) {
		StudentService ss=new StudentService();
		List<Student> list = ss.getStuInfoAsName("÷");
		System.out.println(list);
	}
}
