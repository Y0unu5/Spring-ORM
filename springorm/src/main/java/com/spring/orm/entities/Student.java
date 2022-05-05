package com.spring.orm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student

{
	@Id
	@Column(name = "student_id")
	private int studentId;
	@Column(name = "studnet_name")
	private String studentName;
	@Column(name = "studnet_city")
	private String studnetCity;

	public Student() {

	}

	

	
	public Student(int studentId, String studentName, String studnetCity) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studnetCity = studnetCity;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studnetCity=" + studnetCity
				+ "]";
	}

}
