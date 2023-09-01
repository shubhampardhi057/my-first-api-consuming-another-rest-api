package com.prowings.model;

public class Subjects {

	int id;
	String subjectName;
	String teacherName;
	
	
	public Subjects() {
		super();
	}


	public Subjects(int id, String subjectName, String teacherName) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		this.teacherName = teacherName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSubjectName() {
		return subjectName;
	}


	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}


	public String getTeacherName() {
		return teacherName;
	}


	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}


	@Override
	public String toString() {
		return "Subjects [id=" + id + ", subjectName=" + subjectName + ", teacherName=" + teacherName + "]";
	}
	
	
}
