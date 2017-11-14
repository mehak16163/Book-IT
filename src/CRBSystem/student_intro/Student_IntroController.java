package CRBSystem.student_intro;

import java.io.IOException;

import Backend.Student;
import Backend.User;
import CRBSystem.Main;
import javafx.fxml.FXML;
import javafx.scene.control.*;


/**
*
* <h1> Student</h1>
* <p>This class basically contains Controller for Student Dashboard.</p>
*
*
* @author Mehak Gupta
* @author Pankhuri Kasliwal
* @version 1.0
* @since October15,2017
*
*
*/

public class Student_IntroController {
	
	@FXML
	private   Label name;
	@FXML
	
	private  Label email ;
	 
	/**
	*
	* <p> Method that sets the name and email on the top of the page. </p>
	* @param a User
	*
	*/

	public void  setScreen(User a) {
		name.setText(a.getName());
		email.setText(a.getEmail());
	}
	@FXML

	/**
	*
	* <p> Method that helps to view Pre-Requisites. </p>
	* @throws IOException If an input or output exception occured.
	*
	*/

	private void viewPreReq() throws IOException {
		Main.showPrereq();
	}
	@FXML

	/**
	*
	* <p> Method that takes to the page for searching the courses. </p>
	* @throws IOException If an input or output exception occured.
	*
	*/
	private void search() throws IOException {
		Main.showSearchCourses();
	}
	@FXML

	/**
	*
	* <p> Method that logs out and takes to the main page. </p>
	* @throws IOException If an input or output exception occured.
	*
	*/
	private void logout() throws IOException {
		Main.showMainPage();
	}
	
	@FXML

	/**
	*
	* <p> Method that takes to the page where we can select to view the timetable. </p>
	* @throws IOException If an input or output exception occured.
	*
	*/
	private void timetable() throws IOException {
		Main.showTimeTable();
	}
	@FXML

	/**
	*
	* <p> Method that links to the page where we can book a room, cancek booking and view room availability. </p>
	* @throws IOException If an input or output exception occured.
	*
	*/
	private void book_cancel() throws IOException {
		Main.book_cancel();
	}
}
