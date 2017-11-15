package CRBSystem.FacultyIntro;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import Backend.Faculty;
import Backend.Request;
import Backend.Student;
import CRBSystem.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ViewControllerBooking {
	private ObservableList<String> list = FXCollections.observableArrayList();

	@FXML 
	private  ListView lw;
	@FXML private void showBookings() throws FileNotFoundException, ClassNotFoundException, IOException {
		list.clear();
		Faculty s = (Faculty) Main.getCurr();
		Faculty s_ = Faculty.deserialise("./src/Database/faculty/"+s.getName()+".txt");
		HashMap<Integer, Request> hm = s_.getRequest();
		if (hm.isEmpty()) {
			list.add("No requests");
		}
		else {
			for (int i : hm.keySet()) {
				list.add(i + " " + hm.get(i).getRoomname());
			}
		}
		
		lw.setItems(list);
	}
	@FXML private void back() throws IOException {
		Main.showFacultyIntro();
	}
}
