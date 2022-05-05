package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		ApplicationContext c = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = c.getBean("studentDao", StudentDao.class);

		Student student = new Student(123, "Asif", "Tumkur");
		int r = studentDao.insert(student);
		System.out.println("inserted...." + r);

		// Retrieve

		Student student1 = studentDao.getStudent(123);
		System.out.println(student1);

		// Retrieve All

		List<Student> student2 = studentDao.getAllStudents();
		System.out.println(student2);

		// delete

		Student student3 = studentDao.delete(123);
		System.out.println(student3);

		// Update
		studentDao.updateStudent(null);
	}
}
