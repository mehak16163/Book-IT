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

public class ViewPrereqController {
	@FXML
	private TextField code;
	@FXML
	private TextField name;
	@FXML
	private TextField result;
	@FXML
	private void goback() throws IOException {
		Main.showStudentIntro();
	}
	@FXML
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
