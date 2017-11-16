package CRBSystem.Admin_Intro;

import java.io.IOException;

import Backend.User;
import CRBSystem.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


/**
*
* <h1> Admin</h1>
* <p>This class  contains Controller for Admin Dashboard.</p>
*
*
* @author Mehak Gupta
* @author Pankhuri Kasliwal
* @version 1.0
* @since November 16, 2017
*
*
*/
public class Admin_IntroController {
	@FXML
	private   Label name;
	@FXML
	
	private  Label email ;
	
	/**
	*
	* @throws IOException If an input or output exception occured.
	*
	*/
	public void  setScreen(User a) {
		name.setText(a.getName());
		email.setText(a.getEmail());
	}
	@FXML

	/**
	*
	* @throws IOException If an input or output exception occured.
	*
	*/
	private void gotocancel() throws IOException {
		Main.showCancel();
	}
	@FXML

	/**
	*
	* @throws IOException If an input or output exception occured.
	*
	*/
	private void logout() throws IOException {
		Main.showMainPage();
	}
	@FXML

	/**
	*
	* @throws IOException If an input or output exception occured.
	*
	*/
	private void SignUpReq() throws IOException {
		Main.showSignUpRequests();
	}
	@FXML

	/**
	*
	* @throws IOException If an input or output exception occured.
	*
	*/
	private void CheckAvailabilty() throws IOException {
		Main.showAvailability();
	}
	@FXML


	/**
	*
	* @throws IOException If an input or output exception occured.
	*
	*/
	private void viewreq() throws IOException {
		Main.showRequests();
	}
	
}
