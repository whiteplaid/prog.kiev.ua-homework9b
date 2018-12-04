package com.homework.groupofstudentsbase;

import java.io.Serializable;

public class Student extends Human implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String surename;
	private int age;
	public Student(boolean sex, String eyesColor, String hairColor, String name, String surename, int age) {
		super(sex, eyesColor, hairColor);
		this.name = name;
		this.surename = surename;
		this.age = age;
	}
	public Student() {
		super();	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurename() {
		return surename;
	}
	public void setSurename(String surename) {
		this.surename = surename;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	


	

	
}
