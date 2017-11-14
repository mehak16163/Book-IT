package CRBSystem.student_intro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

import javax.swing.text.html.HTMLDocument.Iterator;

import Backend.Course;
import CRBSystem.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
*
* <h1> View Pre-Requisites </h1>
* <p> This class is the controller class for viewing pre-requisites for a course. </p>
* 
* @author Mehak Gupta
* @author Pankhuri Kasliwal
* @version 1.0
* @since November 2, 2017
*/

public class ViewPrereqController {
	@FXML
	private TextField code;
	@FXML
	private TextField name;
	@FXML
	private TextField result;
	@FXML

	/**
	*
	*
	* <p>This function acts on the back button and upon ction the student intro page is displayed. </p>
	* @throws IOException If an input or output exception occurs.
	*/

	private void goback() throws IOException {
		Main.showStudentIntro();
	}
	@FXML

	/**
	*
	*
	* <p> This method displays the pre-requisites of the required course. </p>
	* @throws FileNotFoundException
	* @throws ClassNotFoundException
	* @throws IOException If an input or output exception occurs.
	*
	*/

	private void prereq() throws FileNotFoundException, ClassNotFoundException, IOException {
		result.setText("");
		String n = name.getText();
		if (n.equals("")) {
			return;
		}
		n = n.toLowerCase();
		String c = code.getText();
		if (c.equals("")) {
			return;
		}
		c = c.toUpperCase();
		File f = new File("./src/Database/courses");
		String[] x1 = f.list();
		for (int i=0;i<x1.length;i++) {
			Course course = Course.deserialise("./src/Database/courses/"+x1[i]);
			if (course.getName().equals(n) && course.getCode().equals(c)) {
				String output = "";
				HashMap<Integer, String> hm = course.getPrereqs();
				for (int key : hm.keySet()) {
					output = output + hm.get(key);
				}
				result.setText(output);
				break;
			}
		}
		
	}
}
