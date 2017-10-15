package Backend;

import java.util.HashMap;

public class ApplicationData {
	private static HashMap<String , Student> students = new HashMap<>();
	private static HashMap<String , Admin> admins = new HashMap<>();
	private static HashMap<String , Faculty> faculty = new HashMap<>();
	
	public static boolean checkStudent(Student s) {
		if (students.containsValue(s))
			return true;
		else return false;
	}
	
	public static boolean checkAdmin(Admin s) {
		if (admins.containsValue(s))
			return true;
		else return false;
	}
	public static boolean checkFaculty(Faculty s) {
		if (faculty.containsValue(s))
			return true;
		else return false;
	}
	
	
}
