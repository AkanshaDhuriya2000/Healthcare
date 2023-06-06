package com.model;

public class Student implements Comparable<Student> {
	private int id;
	private String name;
	private double marks;
	private double getmarks;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public Student(int id,String name,double marks) {
		super();
		this.id=id;
		this.name=name;
		this.marks=marks;
		
		
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + "]";
	}

	@Override
	public int compareTo(Student o) {
		if(this.marks>o.getmarks) {
			return -1;
		}else if(this.marks<o.getMarks()) {
		return 1;
	}else {
		
		return 0;
	}
	}
}

		
			

	


