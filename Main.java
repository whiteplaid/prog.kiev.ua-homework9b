package com.homework.groupofstudentsbase;
import java.io.*;

import javax.swing.*;


public class Main {

	public static void main(String[] args) throws NameRuntimeException {
		Group students = new Group();
		int studentsCount = 0;
		String name;
		String surename;
		int age = 0;
		String eyesColor;
		String hairColor;
		Boolean eyesFound = false;
		Boolean hairFound = false;
		Boolean jsex;
		String[] eyesColorArray = new String[] {"Green","Black","Brown","Grey","Blue"};
		String[] hairColorArray = new String[] {"Green","Black","Brown","Red"};
		DAO dao = new DAO();
		int sex;

			for (;;) {
				try {
					UIManager.put("OptionPane.yesButtonText", "Load group");
			        UIManager.put("OptionPane.noButtonText", "Create new group");
					int loadortype = JOptionPane.showConfirmDialog(null,"Do you want to load group or create new one?","Do you want to load group or create new one?",0);
					
					if (loadortype == 0) {
						File file = null;
						File folder = new File("c:/Users/white/eclipse-workspace/prog.kiev.ua/src/com/homework/groupofstudentsbase/groups/");
						File[] paths;
						
							file = new File(folder,"");
							FilenameFilter fileNameFilter = new FilenameFilter() {
								   
					            @Override
					            public boolean accept(File dir, String name) {
					               if(name.lastIndexOf('.')>0) {
					               
					                 
					                  int lastIndex = name.lastIndexOf('.');
					                  
					                  
					                  String str = name.substring(lastIndex);
					                
					                  
					                  if(str.equals(".csv")) {
					                     return true;
					                  }
					               }
					               
					               return false;
					            }
					         };
					           
					         paths = file.listFiles(fileNameFilter);
					         for (File path : paths) {

								dao.loadGroup(path);
							}
						} else {
					
				
							studentsCount = Integer.valueOf(JOptionPane.showInputDialog("Type in number of students"));
					
							if (studentsCount < 1) throw new NumberFormatException();
							if (studentsCount > 10) throw new MyArrayIndexOutOfBoundsException();
					
							for (int i = 0; i < studentsCount;i++) {
								UIManager.put("OptionPane.yesButtonText", "Man");
								UIManager.put("OptionPane.noButtonText", "Woman");
								sex = JOptionPane.showConfirmDialog(null, "Sex", "Sex", 0);
								if (sex == -1) throw new RuntimeException();
								name = String.valueOf(JOptionPane.showInputDialog(null,"Type in name of student"));
								for (int j = 0; j < name.length();j++) {
									if (!Character.isLetter(name.charAt(j))) throw new NameRuntimeException();
								}
								if (name == null || name.isEmpty()) throw new EmptyFieldRuntimeException();	
								surename = String.valueOf(JOptionPane.showInputDialog(null,"Type in surename of student"));
								for (int j = 0; j < surename.length();j++) {
									if (!Character.isLetter(surename.charAt(j))) throw new NameRuntimeException();	
								}
								if (surename == null || surename.isEmpty()) throw new EmptyFieldRuntimeException();	
								eyesColor = String.valueOf(JOptionPane.showInputDialog(null,"Type in eyes colour"));
								for (int j = 0; j < eyesColorArray.length;j++) {
									if (eyesColor.equalsIgnoreCase(eyesColorArray[j])) {
										eyesFound = true;
									}
								}
								if (!eyesFound) throw new EyesRuntimeException();
								hairColor = String.valueOf(JOptionPane.showInputDialog(null,"Type in hair colour"));
								for (int j = 0; j < hairColorArray.length;j++) {
									if (hairColor.equalsIgnoreCase(hairColorArray[j])) {
										hairFound = true;
									}
								}
								if (!hairFound) throw new HairRuntimeException();
								age = Integer.valueOf(JOptionPane.showInputDialog(null,"Type in age of student"));
								if (age == 0) throw new NumberFormatException();
								if (sex == 1)  jsex = false; else jsex = true;
							
								Student tmp = new Student(jsex, eyesColor, hairColor, name, surename, age);
								students.addStudent(tmp);
							}
							dao.saveGroup(students);	
							break;
						}
					
				} catch (NumberFormatException e) {					
					JOptionPane.showMessageDialog(null, "Wrong number format","error", 0, null);
				} catch (EmptyFieldRuntimeException e) {
					JOptionPane.showMessageDialog(null, "Field can`t be empty","error", 0, null);
				} catch (NameRuntimeException e) {
					JOptionPane.showMessageDialog(null, "You can`t use any symbols but letters","error", 0, null);
				} catch (EyesRuntimeException e) {
					JOptionPane.showMessageDialog(null, "Wrong eyes color, allowed colors are [\"Green\",\"Black\",\"Brown\",\"Grey\",\"Blue\"]","error", 0, null );
				} catch (HairRuntimeException e) {
					JOptionPane.showMessageDialog(null, "Wrong hair color, allowed colors are [\"Green\",\"Black\",\"Brown\",\"Red\"]" ,"error", 0, null);
				} catch (MyArrayIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(null, "The group can`t be more than 10 students", "error", 0, null);
				} 
				break;
			}
			
	}

}
