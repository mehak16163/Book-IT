package CRBSystem.student_intro;

import java.io.IOException;

import CRBSystem.Main;
import javafx.fxml.FXML;

public class Book_Cancel_Controller {
	@FXML
	public void gotocancel() throws IOException {
		Main.showCancelStudent();
	}
	
	@FXML
	public void gotoBook() throws IOException {
		Main.showBookStudent();
	}
	@FXML
	public void goBack() throws IOException {
		Main.showStudentIntro();
	}
	@FXML
	public void checkava() throws IOException {
		Main.showAvailability();
	}
	@FXML
	public void ViewBooking() throws IOException {
		Main.showReq();
	}
	
}
