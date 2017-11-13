package Backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Request implements Serializable , Comparable {
	static int counter =1;
	private int id;
	private Student student;
	private String purpose;
	private int capacity;
	private String roomname;
	private Boolean accepted = false;
	private Boolean valid ;
	private Room room;
	private String time;
	private String day;
	public String date;
	public Request(Student s , String p , String r ,int c,  String d , String t) {
		id = counter;
		student =s;
		purpose = p;
		roomname = r;
		capacity =c;
		day =d;
		time =t;
		counter++;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		date = dtf.format(localDate); 
	}
	
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
	public String getDay() {
		return day;
	}

	@Override
	public int compareTo(Object a) {
		Request req = (Request)a;
		if (req.id == this.id)
			return 1;
		return 0;
	}
	
	public static void main(String[] args) {
		
	}
	
}
