package CRBSystem.view;

import java.io.IOException;
import CRBSystem.Main;
import javafx.fxml.FXML;

public class IntroPageController {
	private Main main;
	@FXML
	private void gotoLogin() throws IOException {
		main.showLogin();
	}
	@FXML
	private void gotoSignUp() throws IOException{
		main.showSignUp();
	}
}
