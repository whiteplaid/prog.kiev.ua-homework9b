package com.homework.groupofstudentsbase;

import java.io.*;

public class DAO implements GroupDAO, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Group group;
	private Faculty faculty = new Faculty();

	public DAO(String id, Group group) {
		super();
		this.id = id;
		this.group = group;
	}

	public DAO() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public void saveGroup(Group group) {
		String id;
		id = "" + Math.random();
		File folder = new File("c:/Users/white/eclipse-workspace/prog.kiev.ua/src/com/homework/groupofstudentsbase/groups/");
		File file = new File(folder,"" + id + ".csv");
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
			System.out.println("Saving");
					oos.writeObject(group);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Group loadGroup(File id) {
		Group group = new Group();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(id))){
			group = (Group) ois.readObject();
			faculty.addGroup(group);
			System.out.println(group);
			} catch (Exception  e) {
				e.printStackTrace();
			}
		return group;
	}
}
