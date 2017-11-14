package CRBSystem.Admin_Intro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import Backend.Request;
import Backend.Room;
import Backend.Student;
import CRBSystem.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.time.temporal.ChronoUnit;
public class Respond_Controller {
	@FXML
	private Label acce;
	@FXML
	private TextField id;
	@FXML
	private TextField room;
	@FXML
	private void goback() throws IOException {
		Main.showAdminIntro();
	}
	@FXML
	private ListView lw;
	private ObservableList<String> list = FXCollections.observableArrayList();

	@FXML
	private void list() throws FileNotFoundException, ClassNotFoundException, IOException {
		list.clear();
		acce.setVisible(false);
		File file = new File("./src/Database/requests");
		String[] x1 = file.list();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		for (int i=0;i<x1.length;i++) {
			Request request = Request.deserialise("./src/Database/requests/"+x1[i]);
			if (ChronoUnit.DAYS.between(localDate , request.reqdate)>5) {
				File f = new File("./src/Database/requests/"+x1[i]);
				Student s = request.getStudent();
				s.getRequests().remove(request.getId());
				s.serialise();
				f.delete();
				continue;
			}
			
			if (localDate.isAfter(request.getDate())) {
				if (request.getAccepted()==true) {
					request.remove();
					continue;
				}
				else {
					File f = new File("./src/Database/requests/"+x1[i]);
					Student s = request.getStudent();
					s.getRequests().remove(request.getId());
					s.serialise();
					f.delete();
					continue;
				}
			}
			if (request.accepted==true) {
				continue;
			}
			String output = request.getId() + " " + request.getStudent().getName() + " " + request.getPurpose() + " " + request.getRoomname() + " " + request.getCapacity()+" " + request.getDate().getDayOfWeek().name().toLowerCase();
			list.add(output);
		}
		lw.setItems(list);
	}
	
	@FXML
	private void accept() throws FileNotFoundException, ClassNotFoundException, IOException {
		acce.setVisible(false);
		if (id.getText().equals(""))
			return;
		if (room.getText().equals(""))
			return;
		int id_ = Integer.parseInt(id.getText());
		String room_ = room.getText().toLowerCase();
		File file = new File("./src/Database/requests");
		String[] x1 = file.list();
		Request request=null;
		for (int i=0;i<x1.length;i++) {
			request = Request.deserialise("./src/Database/requests/"+x1[i]);
			if (request.getId()==id_) {
				break;
			}
		}
		request.accepted=true;
		acce.setVisible(true);
		
		File file1 = new File("./src/Database/rooms");
		String[] x2 = file1.list();
		Room r = null;
		for (int i=0;i<x2.length;i++) {
			r = (Room) Room.deserialise("./src/Database/rooms/"+x2[i]);
			if (r.getName().equals(room_)) {
				break;
			}
		}
		request.setRoom(r);
		request.serialise();
		request.add();
		
	}
	
	@FXML
	public void reject() throws FileNotFoundException, ClassNotFoundException, IOException {
		acce.setVisible(false);
		if (id.getText().equals(""))
			return;
		int id_ = Integer.parseInt(id.getText());
		File file = new File("./src/Database/requests");
		String[] x1 = file.list();
		Request request=null;
		for (int i=0;i<x1.length;i++) {
			request = Request.deserialise("./src/Database/requests/"+x1[i]);
			if (request.getId()==id_) {
				break;
			}
		}
		File f = new File("./src/Database/requests/"+request.getId()+".txt");
		f.delete();
		Student s = request.getStudent();
		s.getRequests().remove(request.getId());
		s.serialise();
	}
	
	
		
	
}
