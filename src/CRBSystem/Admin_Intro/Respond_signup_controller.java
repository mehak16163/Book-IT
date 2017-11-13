package CRBSystem.Admin_Intro;

import java.awt.TextArea;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import Backend.Faculty;
import Backend.SignUpRequest;
import Backend.Student;
import CRBSystem.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Respond_signup_controller {
	@FXML
	private ListView lw;
	private ObservableList<String> list = FXCollections.observableArrayList();
	@FXML 
	private TextField tf;
	@FXML
	private TextField ta;
	@FXML
	private void populate() throws FileNotFoundException, ClassNotFoundException, IOException {
		
		File file = new File("./src/Database/signup");
		String[] x1 = file.list();
		for (int i=0;i<x1.length;i++) {
			SignUpRequest st =(SignUpRequest) SignUpRequest.deserialise("./src/Database/signup/"+x1[i]);
			String request = st.getName() + " " + st.getType();
			list.add(request);
		}
		if(list.isEmpty()) {
			return;
		}
		System.out.println(list.get(0));
		lw.setItems(list);
	}
	@FXML
	private void Accept() throws FileNotFoundException, ClassNotFoundException, IOException {
		String name = tf.getText();
		if(tf.getText().equals("")) {
			return;
		}
		File file = new File("./src/Database/signup");
		String[] x1 = file.list();
		for (int i=0;i<x1.length;i++) {
			SignUpRequest st =(SignUpRequest) SignUpRequest.deserialise("./src/Database/signup/"+x1[i]);
			if(name.equals(st.getName())) {
				if (st.getType().equals("student")) {
					Student s = new Student(st.getName(), st.getEmail() , st.getPass());
					s.serialise();
					File f = new File("./src/Database/signup/"+st.getName()+".txt");
					f.delete();
				}
				else {
					Faculty s = new Faculty(st.getName(), st.getEmail() , st.getPass());
					s.serialise();
					File f = new File("./src/Database/signup/"+st.getName()+".txt");
					f.delete();
				}
				break;
			}
		}
	}
	@FXML
	private void ShowDetails() throws FileNotFoundException, ClassNotFoundException, IOException {
		String name = tf.getText();
		if(tf.getText().equals("")) {
			return;
		}
		File file = new File("./src/Database/signup");
		String[] x1 = file.list();
		for (int i=0;i<x1.length;i++) {
			SignUpRequest st =(SignUpRequest) SignUpRequest.deserialise("./src/Database/signup/"+x1[i]);
			if(name.equals(st.getName())) {
				ta.setText(st.getName() +" " + st.getEmail() +" " + st.getType() +" " + st.getPass());
			}
			break;
		}
	}
	@FXML
	private void back() throws IOException {
		Main.showAdminIntro();
	}
}
