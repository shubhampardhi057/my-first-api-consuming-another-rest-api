package com.prowings.model;

import java.util.List;

public class Student {
	
	int id;
	int roll;
	String name;

	List<Subjects> subjects;

	public Student() {
		super();
	}

	public Student(int id, int roll, String name, List<Subjects> subjects) {
		super();
		this.id = id;
		this.roll = roll;
		this.name = name;
		this.subjects = subjects;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", roll=" + roll + ", name=" + name + ", subjects=" + subjects + "]";
	}
	
	
	
	
}
