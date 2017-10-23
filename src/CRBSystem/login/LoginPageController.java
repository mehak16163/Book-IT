package CRBSystem.login;
import Backend.Student;

import java.io.IOException;

import Backend.Admin;
import Backend.ApplicationData;
import Backend.Faculty;
import Backend.Student;
import CRBSystem.Main;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginPageController {
	
	//private Main main;
	@FXML
	private TextField user_name;
	@FXML 
	private TextField email;
	@FXML 
	private PasswordField pass;
	@FXML
	private RadioButton isstudent;
	@FXML
	private RadioButton isadmin;
	@FXML
	private RadioButton isfaculty;
	@FXML
	private Label credential;
	@FXML
	private Label warning_name;
	@FXML
	private Label warning_email;
	@FXML
	private Label warning_pass;
	@FXML
	private Label warning_radio;
	@FXML
	private void gotoMain() throws IOException {
		Main.showMainPage();
	}
	@FXML
	private void loginclicked() throws IOException {
		boolean check=true;
		credential.setVisible(false);
		warning_name.setVisible(false);
		warning_email.setVisible(false);
		warning_pass.setVisible(false);
		warning_radio.setVisible(false);
		if (user_name.getText().equals("")) {
			warning_name.setVisible(true);
			credential.setVisible(true);
			check=false;
		}
		if(email.getText().equals("")) {
			warning_email.setVisible(true);
			credential.setVisible(true);
			check=false;
		}
		if(pass.getText().equals("")) {
			warning_pass.setVisible(true);
			credential.setVisible(true);
			check = false;
		}
		if(!(isstudent.isSelected() || isadmin.isSelected() || isfaculty.isSelected())) {
			warning_radio.setVisible(true);
			credential.setVisible(true);
			check = false;
		}
		if (check) {
			if (isstudent.isSelected()) {
				Student temp = new Student(user_name.getText(), email.getText(), pass.getText());
				check = ApplicationData.checkStudent(temp);
				Main.showStudentIntro( temp);
					}
			if (isadmin.isSelected()) {
				Admin temp = new Admin(user_name.getText(), email.getText(), pass.getText());
				check = ApplicationData.checkAdmin(temp);
				Main.showAdminIntro(temp);
			}
			if (isfaculty.isSelected()) {
				Faculty temp = new Faculty(user_name.getText(), email.getText(), pass.getText());
				check = ApplicationData.checkFaculty(temp);
				if (!check) {
					credential.setVisible(true);
					return;
				}
				else {
					//go to faculty page
				}
			}
		}
	}
}
