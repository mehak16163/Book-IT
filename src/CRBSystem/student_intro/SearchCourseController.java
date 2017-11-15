package CRBSystem.student_intro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import Backend.Course;
import Backend.Student;
import Backend.Timetable;
import CRBSystem.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


/**
*
* <h1> Respond to SignUp Requests</h1>
* <p>This class basically contains methods and functions that help the admin to react to signup requests ,accept them or reject as well as show the details of various people who have signed up.</p>
*
*
* @author Mehak Gupta
* @author Pankhuri Kasliwal
* @version 1.0
* @since November 3, 2017
*
*
*/

public class SearchCourseController {
	@FXML
	private Label warning2;
	@FXML
	private Label warning ; 
	@FXML
	private Label added;
	@FXML
	private TextField post;
	@FXML
	private ListView lw;
	private ObservableList<String> list = FXCollections.observableArrayList();
	@FXML
	private TextField name;
	@FXML

	/**
	*
	* <p>  </p>
	* @throws IOException If an input or output exception occured.
	*
	*
	*
	*/
	private void goBack() throws IOException {
		warning2.setVisible(false);
		warning.setVisible(false);
		added.setVisible(false);
		list.clear();
		Main.showStudentIntro();
	}
	@FXML

	/**
	*
	* <p> Method for searching courses. </p>
	* @throws FileNotFoundException
	* @throws ClassNotFoundException
	* @throws IOException If an input or output exception occured.
	*
	*
	*/
	private void search() throws FileNotFoundException, ClassNotFoundException, IOException {
		list.clear();
		warning2.setVisible(false);
		warning.setVisible(false);
		String text = post.getText().toLowerCase();
		String[] postc = text.split(" ");
		if (text.equals("")) {
			return;
		}
		File f = new File("./src/Database/courses");
		String[] x = f.list();
		for (int i=0;i<x.length;i++) {
			Course c = Course.deserialise("./src/Database/courses/"+x[i]);
			HashMap<String , Integer> hm = c.getPost();
			int j;
			for ( j= 0 ;j<postc.length;j++) {
				if( !hm.containsKey(postc[j])){
					break;
				}
			}
			if (j==postc.length) {
				list.add(c.getName().toUpperCase() + " " + c.getCode());
			}
		}
		if (list.isEmpty()) {
			list.add("No such course");
		}
		lw.setItems(list);
		
	}
	
	@FXML

	/**
	*
	*
	*
	* <p> Method to add courses to the student Database. </p>
	* @throws FileNotFoundException
	* @throws ClassNotFoundException
	* @throws IOException If an input or output exception occured
    *
	*
	*/
	private void addCourse() throws FileNotFoundException, ClassNotFoundException, IOException {
		warning.setVisible(false);
		warning2.setVisible(false);
		added.setVisible(false);
		Student s=null;
		String c = name.getText();
		if (c.equals("")) {
			System.out.println("yo");
			return;
		}
		else {
			c = c.toLowerCase();
			Student s1 = (Student)Main.getCurr();
			File file = new File("./src/Database/students");
			String[] x1 = file.list();
			for(int y=0;y<x1.length;y++) {
				 s =  Student.deserialise("./src/Database/students/"+x1[y]);
				if (s.compareTo(s1)==1) {
					break;
				}
			}
			File f = new File("./src/Database/courses");
			String[] x = f.list();
			int i;
			Course co = null;
			for ( i=0;  i<x.length;i++) {
				co = Course.deserialise("./src/Database/courses/"+x[i]);
				if (co.getName().equals(c) ) {
					break;
				}
			}
			if (i==x.length) {
				return;
			}
			if (s.getCourses().containsKey(co.getName())) {
				warning2.setVisible(true);
				return;
			}
			Timetable course_table = co.getTime();
			Timetable student  = s.getTable();
			for (int j=0; j<5;j++) {
				for (int k=0 ; k<20 ; k++) {
					if (course_table.table[j][k] == true && student.table[j][k] ==true) {
						warning.setVisible(true); 
						return;
					}
				}	
			}
			added.setVisible(true);
			s.getCourses().put(co.getName(), co);
			co.getStudents().put(s.getName(), s);
			for (int j=0; j<5;j++) {
				for (int k=0 ; k<20 ; k++) {
					if (course_table.table[j][k] == true ) {
						student.table[j][k]=true;
					}
				}	
			}
			
			co.serialise();
			s.serialise();
		}
	}
	
}
