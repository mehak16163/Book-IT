package CRBSystem.student_intro;

import java.awt.TextArea;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import Backend.Request;
import Backend.Student;
import CRBSystem.Main;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BookRoomController {
	@FXML
	private Label accept;
	@FXML
	private TextField name;
	@FXML
	private DatePicker date;
	@FXML
	private TextField from;
	@FXML
	private TextField to;
	@FXML
	private TextField room;
	@FXML
	private TextField capacity;
	@FXML
	private TextField purpose;
	@FXML
	private Label warning;
	@FXML
	private Label id;
	@FXML
	public void reset() {
		name.setText("");
		from.setText("");
		to.setText("");
		capacity.setText("");
		purpose.setText("");
		
	}
	@FXML
	public void gotoStudentIntro() throws IOException {
		Main.showStudentIntro();
	}
	@FXML
	public void submit() throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean check = true;
		warning.setVisible(false);
		if (capacity.getText().equals("")) {
			check = false;
			warning.setVisible(true);
		}
		if (purpose.getText().equals("")) {
			check = false;
			warning.setVisible(true);
		}
		if (name.getText().equals("")) {
			check = false;
			warning.setVisible(true);
		}
		if (to.getText().equals("")) {
			check = false;
			warning.setVisible(true);
		}
		if (from.getText().equals("")) {
			check = false;
			warning.setVisible(true);
		}
		if (room.getText().equals("")) {
			check = false;
			warning.setVisible(true);
		}
		
		
		if (check) {
			String time = from+"\\-"+to;
			Request req = new Request((Student)Main.getCurr(),purpose.getText(),room.getText(),Integer.parseInt(capacity.getText()),date.getValue() ,time);
			req.serialise();
			id.setText(Integer.toString(req.getId()));
			id.setVisible(false);
			Student s = Student.deserialise("./src/Database/students/"+Main.getCurr().getName()+".txt");
			s.getRequests().put(req.getId(), req);
			s.serialise();
			accept.setVisible(true);
		}
	}
}


