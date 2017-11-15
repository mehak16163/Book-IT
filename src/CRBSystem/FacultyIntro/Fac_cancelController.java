package CRBSystem.FacultyIntro;

import java.io.FileNotFoundException;
import java.io.IOException;

import Backend.Faculty;
import Backend.Request;
import Backend.Student;
import CRBSystem.Main;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Fac_cancelController {
	@FXML 
	private TextField to ;
	@FXML private DatePicker date;
	
	@FXML private TextField name;
	@FXML private Label warning;
	@FXML private TextField from;
	@FXML private Label confirm;
	@FXML private TextField room;
	@FXML private TextField eid;
	@FXML private TextField capacity;
	@FXML private void submit() throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean check = true;
		warning.setVisible(false);
		if (capacity.getText().equals("")) {
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
			Request req = new Request(null,"",room.getText(),Integer.parseInt(capacity.getText()),date.getValue() ,time);
			req.accepted=true;
			req.serialise();
			eid.setText(Integer.toString(req.getId()));
			eid.setVisible(false);
			Faculty f = Faculty.deserialise("./src/Database/faculty/"+name.getText()+".txt");
			f.getRequest().put(req.getId(), req);
			f.serialise();
			req.add();
			
			confirm.setVisible(true);
		}
	}
	@FXML private void back() throws IOException {
		Main.showFacultyIntro();
	}
	@FXML private void log() throws IOException {
		Main.showMainPage();
	}
	@FXML
	public void reset() {
		name.setText("");
		from.setText("");
		to.setText("");
		capacity.setText("");
		warning.setVisible(false);
		confirm.setVisible(false);
		
	}
}
