package com.homework.groupofstudentsbase;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Group  implements Voencom, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Student> group = new ArrayList<>();

	public Group(ArrayList<Student> group) {
		super();
		this.group = group;
	}

	public Group() {
		super();
	}

	public ArrayList<Student> getGroup() {
		return group;
	}

	public void setGroup(ArrayList<Student> group) {
		this.group = group;
	}

	public void addStudent (Student one){
		if (group.size() < 10) {
			group.add(one);
		} else {
			System.out.println("The group can`t be more than 10 students");
		}
	}
	public void deleteStudent (Student one) {
		for (Student student : group) {
			if (student.equals(one)) {
				group.remove(student);
			}
		}
	}
	public ArrayList<Student> findStudent (String sureName) {
		int result = 0;
		ArrayList<Student> students = new ArrayList<>();
		ArrayList<String> str = new ArrayList<>();
			sort();
			for (Student student : group) {
				if (student.getSurename().equalsIgnoreCase(sureName)) {
					students.add(student);
					str.add(student.getName() + " " + student.getSurename());
					result++;
				}
			}
		if (result == 0) JOptionPane.showMessageDialog(null,"There is no student with this surename " + sureName + " in this group");
		if (str.size() > 0)JOptionPane.showMessageDialog(null,str);
		
		return students;
	}

	public ArrayList<Student> findStudentByAge (int age) {
		int result = 0;
		ArrayList<Student> students = new ArrayList<>();
		ArrayList<String> str = new ArrayList<>();
			sort();
			for (Student student : group) {
				if (student.getAge() == age) {
					students.add(student);
					str.add(student.getName() + " " + student.getSurename() + " age " + student.getAge());
				}
			}
		if (result == 0) JOptionPane.showMessageDialog(null, "There is no students with this age " + age + " in this group");
		if (str.size()>0)JOptionPane.showMessageDialog(null,str);
		return students;
	}
	
	@Override
	public ArrayList<Student> findRecruit() {
		int recruitsCount = 0;
		ArrayList<Student> recruits = new ArrayList<>();
		ArrayList<String> recs = new ArrayList<>();
		for (Student student : group) {
			if (student.getAge() >= 18 && student.isSex()) {
				recruitsCount +=1;
				recruits.add(student);
				recs.add(student.getName() + " " + student.getSurename());
			}
		}

			if (recruitsCount == 0) {
				JOptionPane.showMessageDialog(null,"There are no students in this group that can be recruited to the Army","Voencom",1);
			} else {
				JOptionPane.showMessageDialog(null, recs, "Recruits", 1);
			}
		return recruits;
	}


	private boolean compare(String one, String two) {
		int check = 0;
        try {
            check = one.compareTo(two);
        } catch (NullPointerException e) {
            check = 0;
        }
        return (check > 0) ? false : true;
	}

	public void sort () {
		group.sort(null);
	}

}
