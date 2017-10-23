package CRBSystem.FacultyIntro;

//package CRBSystem.faculty_intro;

import java.io.IOException;

import Backend.User;
import CRBSystem.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Faculty_IntroController {

	
	@FXML
	private   Label name;
	@FXML
	
	private  Label email ;
	
	
	public void  setScreen(User a) {
		name.setText(a.getName());
		email.setText(a.getEmail());
	}
	
	@FXML
	private void logout() throws IOException {
		Main.showMainPage();
	}
	
	
}
