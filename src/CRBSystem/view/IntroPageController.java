package CRBSystem.view;

import java.io.IOException;
import CRBSystem.Main;
import javafx.fxml.FXML;



     /**
	 * 
     * <h1> Introduction Page </h1>
     * <p> Linking Page for login and signup. </p>
     * @author Mehak Gupta
     * @author Pankhuri Kasliwal
     * @version 1.0
     * @since November 11, 2017
	 *
	 *
	 *
	 *
	 *
	 */
public class IntroPageController {
	//private Main main;
	@FXML

	/**
	*
	* <p> Method that links Intropage to login page. <p/>
	* @throws IOException If an input or output exception occured 
	*
	*/
	private void gotoLogin() throws IOException {
		Main.showLogin();
	}
	@FXML

	/**
	*
	* <p> Method that links Intropage to Sign up page. <p/>
	* @throws IOException If an input or output exception occured 
	*
	*/
	private void gotoSignUp() throws IOException{
		Main.showSignUp();
	}
}
