package CRBSystem.Admin_Intro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Backend.Request;
import Backend.Student;
import CRBSystem.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class Respond_Controller {
	@FXML
	private void goback() throws IOException {
		Main.showAdminIntro();
	}
	@FXML
	private ListView lw;
	private ObservableList<String> list = FXCollections.observableArrayList();

	@FXML
	private void list() throws FileNotFoundException, ClassNotFoundException, IOException {
		File file = new File("./src/Database/requests");
		String[] x1 = file.list();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		String currdate = dtf.format(localDate);
		int date = Integer.parseInt(currdate.split("/")[2])*(Integer.parseInt(currdate.split("/")[1])-1);
		for(int i =0 ; i<x1.length;i++) {
			Request r = Request.deserialise("./src/Database/requests/"+x1[i]);
			int rdate = Integer.parseInt(r.date.split("/")[2])*(Integer.parseInt(r.date.split("/")[1])-1);
			if ((date-rdate)>5) {
				File f = new File("./src/Database/requests/"+ x1[i]);
				Student s = r.getStudent();
				s.getRequests().remove(r.getId());
				s.serialise();
				f.delete();
				continue;
			}
			String display = r.getId() + " " + r.getStudent().getName() + " " + r.getDay() + " " + r.getRoomname() + " " + r.getPurpose() + " " + r.getCapacity() ;
			list.add(display);
		}
		if (list.isEmpty())
			return;
		else {
			lw.setItems(list);
		}
	}
}
