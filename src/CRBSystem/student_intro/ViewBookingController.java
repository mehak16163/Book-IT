package CRBSystem.student_intro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import Backend.Request;
import Backend.SignUpRequest;
import Backend.Student;
import CRBSystem.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ViewBookingController {
	private ObservableList<String> list = FXCollections.observableArrayList();

	@FXML 
	private  ListView lw;
	@FXML private void showBookings() throws FileNotFoundException, ClassNotFoundException, IOException {
		list.clear();
		Student s = (Student) Main.getCurr();
		Student s_ = Student.deserialise("./src/Database/students/"+s.getName()+".txt");
		HashMap<Integer, Request> hm = s_.getRequests();
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
		Main.showStudentIntro();
	}
}
