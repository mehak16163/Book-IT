package CRBSystem.viewTable;

import java.io.IOException;

import CRBSystem.Main;
import javafx.fxml.FXML;


 /**
	 * 
     * <h1> Timetable Controller </h1>
     * <p> Controller for Time table. </p>
     * @author Mehak Gupta
     * @author Pankhuri Kasliwal
     * @version 1.0
     * @since November 14, 2017
	 *
	 *
	 *
	 *
	 *
	 */
public class TimeTableController {
	@FXML

	/**
	*
	* <p> Acts on back button. <p/>
	* @throws IOException If an input or output exception occured 
	*
	*/
	private void back() throws IOException {
		Main.showStudentIntro();
	}
}
