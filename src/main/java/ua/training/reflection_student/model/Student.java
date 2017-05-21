package ua.training.reflection_student.model;

import java.io.Serializable;

import ua.training.reflection_student.utils.annotation.RunnableMethod;

public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String fullName;
	private int course;

	public Student() {
	}

	public Student(Long id) {
		this.id = id;
	}

	public Student(Long id, String fullName, int course) {
		this.id = id;
		this.fullName = fullName;
		this.course = course;
	}

	@RunnableMethod
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@RunnableMethod
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@RunnableMethod
	public int getCourse() {
		return course;
	}

	public void setCourse(int course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return getClass() + ": id= " + id + ", fullName= " + fullName + ", course =" + course;
	}

}
