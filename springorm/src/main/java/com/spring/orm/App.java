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

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("PRESS 1 for Create Student");
			System.out.println("PRESS 2 for Get Student");
			System.out.println("PRESS 3 for Get All Students");
			System.out.println("PRESS 4 for Update Student");
			System.out.println("PRESS 5 for Delete Student");
			System.out.println("PRESS 6 for Exit");

			try {
				int input = Integer.parseInt(br.readLine());
				switch (input) {
				case 1:
					// Add a new Student
					// Taking I/p from user
					System.out.println("Enter User Id");
					int uId = Integer.parseInt(br.readLine());

					System.out.println("Enter User Name");
					String uName = br.readLine();

					System.out.println("Enter User City");
					String uCity = br.readLine();
					// Saving student object to db by calling insert of student dao
					Student s = new Student();
					s.setStudentId(uId);
					s.setStudentName(uName);
					s.setStudentCity(uCity);

					int r = studentDao.insert(s);
					System.out.println(r + " student added");
					System.out.println("*******************************");
					System.out.println();

					break;
				case 2:
					// Single Student
					System.out.println("Enter User Id");
					int uId1 = Integer.parseInt(br.readLine());
					Student student = studentDao.getStudent(uId1);

					System.out.println("Id: " + student.getStudentId());
					System.out.println("Name: " + student.getStudentName());
					System.out.println("City: " + student.getStudentCity());
					break;
				case 3:
					// Display All Students
					List<Student> st = studentDao.getAllStudents();
					for (Student s1 : st) {
						System.out.println("Id: " + s1.getStudentId());
						System.out.println("Name: " + s1.getStudentName());
						System.out.println("City: " + s1.getStudentCity());
						System.out.println("______________________________________");
					}

					break;
				/*
				 * case 4: //Update System.out.println("Enter User Name"); String name =
				 * br.readLine();
				 * 
				 * System.out.println("Enter User City"); String city = br.readLine();
				 * 
				 * System.out.println("Enter User Id"); int id1 =
				 * Integer.parseInt(br.readLine()); Student s12=new Student();
				 * s12.setStudentName(name); s12.setStudentCity(city);
				 * studentDao.updateStudent(s12);
				 * System.out.println("Student Updated...........");
				 * 
				 * 
				 * break;
				 */
				case 5:
					// Delete
					System.out.println("Enter User Id");
					int id = Integer.parseInt(br.readLine());

					studentDao.delete(id);

					System.out.println("Student deleted.......");

					break;
				case 6:
					//Exit
					
					break;

				}

			} catch (Exception e) {
				System.out.println("Invalid Input try with another one...");
				e.printStackTrace();
			}

		}
	}
}
