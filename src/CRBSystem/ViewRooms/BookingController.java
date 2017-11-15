package CRBSystem.ViewRooms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import Backend.Admin;
import Backend.Room;
import Backend.Student;
import Backend.Timetable;
import CRBSystem.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;



    /**
	 * 
     * <h1> Booking Controller </h1>
     * <p> Controller for Bookings. </p>
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
public class BookingController {
	@FXML 
	private ListView lw;
	private ObservableList<String> list = FXCollections.observableArrayList();
	@FXML
	private TextField from;
	@FXML
	private TextField to;
	@FXML
	private TextField day;
	@FXML


	/**
	*
	* <p> Method that notifies the rooms that are availaible for booking for a particular time sot. <p/>
	* @throws IOException If an input or output exception occured 
	* @throws ClassNotFoundException
	* @throws FileNotFoundException
	*
	*/
	private void checkrooms() throws FileNotFoundException, ClassNotFoundException, IOException {
		String start = from.getText();
		String end = to.getText();
		String day_week = day.getText().toLowerCase();
		HashMap<String , Integer> book = new HashMap<>();
		book.put("8.00", 0);
		book.put("8.30", 1);
		book.put("9.00", 2);
		book.put("9.30", 3);
		book.put("10.00", 4);
		book.put("10.30", 5);
		book.put("11.00", 6);
		book.put("11.30", 7);
		book.put("12.00", 8);
		book.put("12.30", 9);
		book.put("1.00", 10);
		book.put("1.30", 11);
		book.put("2.00", 12);
		book.put("2.30", 13);
		book.put("3.00", 14);
		book.put("3.30", 15);
		book.put("4.00", 16);
		book.put("4.30", 17);
		book.put("5.00", 18);
		book.put("5.30", 19);
		book.put("6.00", 20);
		HashMap<String , Integer> days = new HashMap<>();
		days.put("monday", 0);
		days.put("tuesday", 1);
		days.put("wednesday", 2);
		days.put("thursday", 3);
		days.put("friday", 4);
		int st = book.get(start);
		int en = book.get(end) -1;
		File file = new File("./src/Database/rooms");
		String[] x1 = file.list();
		for (int i=0; i<x1.length;i++) {
			Room r = (Room)Room.deserialise("./src/Database/rooms/"+x1[i]);
			String display = "Room Name: " +r.getName() +" Capacity " +r.getCapacity();
			Timetable table = r.getTimeTable();
			
			int j;
			for( j=st ; j<=en ; j++) {
				
				if (!(table.table[days.get(day_week)][j]==false))
					break;
			}
			if (j==en+1) {
			list.add(display);}
			
		}
		if (list.isEmpty())
			return;
		else {
			lw.setItems(list);
		}
	}
	@FXML

	/**
	*
	* <p> Acts on back button. <p/>
	* @throws IOException If an input or output exception occured 
	*
	*/
	private void back() throws IOException {
		if (Main.getCurr() instanceof Admin)
			Main.showAdminIntro();
		else if (Main.getCurr() instanceof Student)
			Main.showStudentIntro();
		else
			Main.showFacultyIntro();
			
	}
}
