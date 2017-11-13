package Backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class ApplicationData {
	private static HashMap<String , Student> students = new HashMap<>();
	private static HashMap<String , Admin> admins = new HashMap<>();
	private static HashMap<String , Faculty> faculty = new HashMap<>();
	
	public static boolean checkStudent(Student s) throws FileNotFoundException, ClassNotFoundException, IOException {
		File file = new File("./src/Database/students");
		String[] x1 = file.list();
		for (int i=0;i<x1.length;i++) {
			Student st = Student.deserialise("./src/Database/students/"+x1[i]);
			if (st.compareTo(s)==1) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkAdmin(Admin s) throws FileNotFoundException, ClassNotFoundException, IOException {
		File file = new File("./src/Database/admins");
		String[] x1 = file.list();
		for (int i=0;i<x1.length;i++) {
			Admin st = Admin.deserialise("./src/Database/admins/"+x1[i]+".txt");
			if (st.compareTo(s)==1) {
				return true;
			}
		}
		return false;
	}
	public static boolean checkFaculty(Faculty s) throws FileNotFoundException, ClassNotFoundException, IOException {
		File file = new File("./src/Database/faculty");
		String[] x1 = file.list();
		for (int i=0;i<x1.length;i++) {
			Faculty st = Faculty.deserialise("./src/Database/faculty/"+x1[i]+".txt");
			if (st.compareTo(s)==1) {
				return true;
			}
		}
		return false;
	}
	
	
}
