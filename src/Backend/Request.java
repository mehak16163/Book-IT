package Backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

     /**
	 * 
     * <h1> Booking Requests </h1>
     * <p> This class has methods that manages booking requests and are required for cancellation of bookings, add bookings,etc. </p>
     * @author Mehak Gupta
     * @author Pankhuri Kasliwal
     * @version 1.0
     * @since November 10, 2017
	 *
	 *
	 *
	 *
	 *
	 */

public class Request implements Serializable , Comparable {
	
	private static final long serialVersionUID = 3437465097933260821L;
	static int counter =1;
	private int id;
	private Student student;
	private String purpose;
	private int capacity;
	private String roomname;
	public boolean accepted = false;
	private Room room;
	private String time;
	private LocalDate date;
	public LocalDate reqdate;
	public Request(Student s , String p , String r ,int c,  LocalDate d , String t) {
		id = counter;
		student =s;
		purpose = p;
		roomname = r;
		capacity =c;
		date =d;
		time =t;
		counter++;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		 reqdate = LocalDate.now();
		
	}
	public int getCapacity() {
		return capacity;
	}

	/**
	*
	* <p> Method that is used to create serialisable objects. </p>
	* @throws FileNotFoundException
	* @throws IOException If an input or output exception occured
	*
	*
	*/
	public void serialise() throws FileNotFoundException, IOException {
		ObjectOutputStream out=null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("./src/Database/requests/"+this.id+".txt"));
			out.writeObject(this);
		}
		finally {
			out.close();
		}
	}

	/**
	*
	* <p> Method used to deserialise the object. </p>
	* @throws FileNotFoundException
	* @throws IOException If an input or output exception occured
	* @throws ClassNotFoundException
	*
	*/
	public static Request deserialise(String x) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in =null;
		Request s1;
		try {
			in = new ObjectInputStream(new FileInputStream(x));
		    s1 = (Request)in.readObject();
			
		}
		finally
		{
			in.close();
			}
		return s1;
	}
	
	/**
	*
	* <p> Getter Method </p>
	* @return Returns counter 
	*
	*
	*
	*/
	public static int getCounter() {
		return counter;
	}

	/**
	*
	* <p> Getter Method </p>
	* @return Returns id of the user 
	*/
	public int getId() {
		return id;
	}

	/**
	*
	* <p> Getter Method </p>
	* @return Returns Student object 
	*
	*
	*/
	public Student getStudent() {
		return student;
	}

	/**
	*
	* <p> Getter Method </p>
	* @return Returns Purpose 
	*
	*/
	public String getPurpose() {
		return purpose;
	}

	/**
	*
	* <p> Getter Method </p>
	* @return Returns roomname 
	*
	*/
	public String getRoomname() {
		return roomname;
	}

	/**
	*
	* <p> Getter Method </p>
	* @return Returns boolean value of accepted
	*/
	public Boolean getAccepted() {
		return accepted;
	}
	
	/**
	*
	* <p> Getter Method </p>
	* @return Returns date 
	*/
	public LocalDate getDate() {
		return date;
	}

	/**
	*
	* <p> Getter Method </p>
	* @return Returns requested date 
	*/
	public LocalDate getreqdate() {
		return reqdate;
	}
	
	/**
	*
	* <p> Setter Method </p>
	* 
	*/
	public void setRoom(Room r) {
		room = r;
	}

	@Override
	public int compareTo(Object a) {
		Request req = (Request)a;
		if (req.id == this.id)
			return 1;
		return 0;
	}
	

	/**
	*
	* <p> Method that takes care of that when a booking request for a room is accepted then for that time duration the boolean variable is made true and room is shown as booked. </p>
	* @throws FileNotFoundException
	* @throws IOException If an input or output exception occured
    *
    *
	*/
	public void add() throws FileNotFoundException, IOException {
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
		Room curr = this.room;
		String start = time.split("\\-")[0];
		String end = time.split("\\-")[1];
		int st = book.get(start);
		int en = book.get(end)-1;
		String day = this.date.getDayOfWeek().name().toLowerCase();
		HashMap<String , Integer> days = new HashMap<>();
		days.put("monday", 0);
		days.put("tuesday", 1);
		days.put("wednesday", 2);
		days.put("thursday", 3);
		days.put("friday", 4);
		int day_int = days.get(day);
		for (int i = st ; i<=en ; i++ ) {
			curr.getTimeTable().table[day_int][i] = true;
		}
		curr.serialise();
		Student s = this.student;
		s.getRequests().remove(id);
		s.getRequests().put(id, this);
		s.serialise();
	}
	


	/**
	*
	* <p> Method that takes care of that when a cancellation request for a room is accepted then for that time duration the boolean variable is made false and room is shown as free. </p>
	* @throws FileNotFoundException
	* @throws IOException If an input or output exception occured
    *
    *
	*/
	public void remove() throws FileNotFoundException, IOException {
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
		Room curr = this.room;
		String start = time.split("//-")[0];
		String end = time.split("//-")[1];
		int st = book.get(start);
		int en = book.get(end)-1;
		String day = this.date.getDayOfWeek().name().toLowerCase();
		HashMap<String , Integer> days = new HashMap<>();
		days.put("monday", 0);
		days.put("tuesday", 1);
		days.put("wednesday", 2);
		days.put("thursday", 3);
		days.put("friday", 4);
		int day_int = days.get(day);
		for (int i = st ; i<=en ; i++ ) {
			curr.getTimeTable().table[day_int][i] = false;
		}
		curr.serialise();
		Student s = this.student;
		s.getRequests().remove(id);
		s.serialise();
		File f = new File("./src/Database/requests/"+id+".txt");
		f.delete();
	}
	
	public static void main(String[] args) {
		
	}
	
}
