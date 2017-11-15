package Backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;



     /**
	 * 
     * <h1> Validation </h1>
     * <p> Check whether the user who is logging in is actually in database or not. </p>
     * @author Mehak Gupta
     * @author Pankhuri Kasliwal
     * @version 1.0
     * @since November 11, 2017
	 *
	 *
	 *
	 *
	 *
	 */
public class ApplicationData {
	
	/**
	*
	* <p> Check if the Student exists in database or not. </p>
	* @throws FileNotFoundException
	* @throws ClassNotFoundException
	* @throws IOException If an input or output exception occured
	* 
	*/
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
	

	/**
	*
	* <p> Check if the Admin exists in database or not. </p>
	* @throws FileNotFoundException
	* @throws ClassNotFoundException
	* @throws IOException If an input or output exception occured
	* 
	*/
	public static boolean checkAdmin(Admin s) throws FileNotFoundException, ClassNotFoundException, IOException {
		File file = new File("./src/Database/admins");
		String[] x1 = file.list();
		for (int i=0;i<x1.length;i++) {
			Admin st = Admin.deserialise("./src/Database/admins/"+x1[i]);
			if (st.compareTo(s)==1) {
				return true;
			}
		}
		return false;
	}

	/**
	*
	* <p> Check if the Faculty exists in database or not. </p>
	* @throws FileNotFoundException
	* @throws ClassNotFoundException
	* @throws IOException If an input or output exception occured
	* 
	*/
	public static boolean checkFaculty(Faculty s) throws FileNotFoundException, ClassNotFoundException, IOException {
		File file = new File("./src/Database/faculty");
		String[] x1 = file.list();
		for (int i=0;i<x1.length;i++) {
			Faculty st = Faculty.deserialise("./src/Database/faculty/"+x1[i]);
			if (st.compareTo(s)==1) {
				return true;
			}
		}
		return false;
	}
	
	
	
}
