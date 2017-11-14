package CRBSystem.student_intro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import Backend.Course;
import CRBSystem.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SearchCourseController {
	@FXML
	private Label warning2;
	@FXML
	private Label warning ; 
	@FXML
	private TextField post;
	@FXML
	private ListView lw;
	private ObservableList<String> list = FXCollections.observableArrayList();
	@FXML
	private TextField name;
	@FXML
	private void goBack() throws IOException {
		warning2.setVisible(false);
		warning.setVisible(false);
		list.clear();
		Main.showStudentIntro();
	}
	@FXML
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
	
}
