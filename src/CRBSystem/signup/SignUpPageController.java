package CRBSystem.signup;
import java.io.IOException;
import CRBSystem.Main;
import javafx.fxml.FXML;


public class SignUpPageController {
	private Main main;
	@FXML
	private void gotoMain() throws IOException {
		main.showMainPage();
	}
}
