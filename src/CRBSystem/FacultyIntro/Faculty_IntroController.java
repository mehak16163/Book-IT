package CRBSystem.FacultyIntro;

//package CRBSystem.faculty_intro;

import java.io.IOException;

import Backend.User;
import CRBSystem.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;



     /**
	 * 
     * <h1> Faculty </h1>
     * <p> Controller Class for faculty that manages Faculty dashboard. </p>
     * @author Mehak Gupta
     * @author Pankhuri Kasliwal
     * @version 1.0
     * @since November 13, 2017
	 *
	 *
	 *
	 *
	 *
	 */
public class Faculty_IntroController {

	
	@FXML
	private   Label name;
	@FXML
	private  Label email ;
	
	/**
	*
	*
	* @param a User
	*
	*
	*/
	public void  setScreen(User a) {
		name.setText(a.getName());
		email.setText(a.getEmail());
	}
	


	/**
	*
	* @throws IOException If an input or output exception occured
	*
	*/
	@FXML
	private void logout() throws IOException {
		Main.showMainPage();
	}
	

	/**
	*
	*
	* @throws IOException If an input or output exception occured
    *
    */
	@FXML
	private void checkava() throws IOException {
		Main.showAvailability();
	}
	@FXML
	private void gotocancel() throws IOException {
		Main.showCancel();
	}
	
	@FXML private void gotoBook() throws IOException {
		Main.gotobook();
	}
	@FXML private void view() throws IOException {
		Main.showFacBooking();
	}
	
	
}
