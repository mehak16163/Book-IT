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
	
	@FXML

	/**
	*
	* @throws IOException If an input or output exception occured
	*
	*/
	private void logout() throws IOException {
		Main.showMainPage();
	}
	@FXML

	/**
	*
	*
	* @throws IOException If an input or output exception occured
    *
    */
	private void checkava() throws IOException {
		Main.showAvailability();
	}
	
	
}
