package Backend;

import java.io.Serializable;
import java.util.Date;

public class Request implements Serializable {
	static int counter =1;
	private final int id=counter;
	private Student student;
	private String purpose;
	private int capacity;
	private String roomname;
	private Boolean accepted = false;
	private Boolean valid ;
	private Room room;
	Date date;
	public Request(Student s , String p , String r ,int c,  Date d) {
		student =s;
		purpose = p;
		roomname = r;
		capacity =c;
		date =d;
	}
	
	public static int getCounter() {
		return counter;
	}
	public int getId() {
		return id;
	}
	public Student getStudent() {
		return student;
	}
	public String getPurpose() {
		return purpose;
	}
	public String getRoomname() {
		return roomname;
	}
	public Boolean getAccepted() {
		return accepted;
	}
	public Boolean getValid() {
		return valid;
	}
	public Date getDate() {
		return date;
	}
	
	
}
