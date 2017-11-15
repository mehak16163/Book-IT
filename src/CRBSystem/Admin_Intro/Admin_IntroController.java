package CRBSystem.Admin_Intro;

import java.io.IOException;

import Backend.User;
import CRBSystem.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Admin_IntroController {
	@FXML
	private   Label name;
	@FXML
	
	private  Label email ;
	
	
	public void  setScreen(User a) {
		name.setText(a.getName());
		email.setText(a.getEmail());
	}
	@FXML
	private void gotocancel() throws IOException {
		Main.showCancel();
	}
	@FXML
	private void logout() throws IOException {
		Main.showMainPage();
	}
	@FXML
	private void SignUpReq() throws IOException {
		Main.showSignUpRequests();
	}
	@FXML
	private void CheckAvailabilty() throws IOException {
		Main.showAvailability();
	}
	@FXML
	private void viewreq() throws IOException {
		Main.showRequests();
	}
	
}
