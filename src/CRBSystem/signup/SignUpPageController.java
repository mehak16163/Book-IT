package CRBSystem.signup;
import java.io.IOException;

import Backend.SignUpRequest;
import CRBSystem.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;


public class SignUpPageController {
	@FXML
	private TextField name;
	@FXML
	private RadioButton student;
	@FXML
	private RadioButton faculty;
	@FXML
	private TextField email;
	@FXML
	private PasswordField pass;
	@FXML
	private PasswordField repass;
	@FXML
	private Label warning;

	@FXML
	private void gotoMain() throws IOException {
		Main.showMainPage();
	}
	@FXML
	private void gotoNext() throws IOException {
		warning.setVisible(false);
		if (!pass.getText().equals(repass.getText())){
			warning.setVisible(true);
		}
		else if (!email.getText().contains("iiitd.ac.in")) {
			warning.setVisible(true);
		}
		else {
			String type;
			if (student.isSelected()) {
				type = "student";
			}
			else
				type = "faculty";
			SignUpRequest request = new SignUpRequest(name.getText() , email.getText(), pass.getText(),type);
			request.serialise();
			Main.gotoSignUp_2();
		}
	}
}
