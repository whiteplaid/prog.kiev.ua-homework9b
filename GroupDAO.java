package com.homework.groupofstudentsbase;

import java.io.File;

public interface GroupDAO {

	default void saveGroup (Group group) {




	
	}
	default Group loadGroup (File id) {
		Group group = new Group();
		return group;
	}
}
