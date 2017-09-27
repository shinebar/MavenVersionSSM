package org.system.api.digester;

import java.util.ArrayList;

public class Student {
	private String name;
	private int age;
	private int grade;
	private ArrayList<Subjects> list = new ArrayList<>();

	public Student() {
		System.out.println("A student go to school");
	}

	public void add(Subjects subjects) {
		System.out.println("add Subjects" + subjects.getName() + "to the Student: " + this.getName());
		list.add(subjects);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		System.out.println("set age of Student:" + name);
		this.age = age;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		System.out.println(" set score of Student:" + name);
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println(" set name pf Student");
		this.name = name;
	}

	public ArrayList<Subjects> getList() {
		return this.list;
	}
}
