package com.homework.groupofstudentsbase;

import java.io.Serializable;
import java.util.ArrayList;

public class Faculty implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Group> faculty = new ArrayList<>(); 

	public Faculty(ArrayList<Group> faculty) {
		super();
		this.faculty = faculty;
	}
	public Faculty() {
		super();
	}

	public ArrayList<Group> getFaculty() {
		return faculty;
	}
	public void setFaculty(ArrayList<Group> faculty) {
		this.faculty = faculty;
	}
	public void addGroup(Group group) {
		faculty.add(group);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
