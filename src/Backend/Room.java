package Backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Room implements Serializable{
	private String name;
	private Timetable bookings;
	private int capacity;
	public int getCapacity() {
		return capacity;
	}
	public Room(String m ,Timetable t , int c) {
		name = m;
		bookings = t;
		capacity =c;
	}
	
	public void serialise() throws FileNotFoundException, IOException {
		ObjectOutputStream out=null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("./src/Database/rooms/"+this.name+".txt"));
			out.writeObject(this);
		}
		finally {
			out.close();
		}
	}
	public static Room deserialise(String x) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in =null;
		Room s1;
		try {
			in = new ObjectInputStream(new FileInputStream(x));
		    s1 = (Room)in.readObject();
			
		}
		finally
		{
			in.close();
			}
		return s1;
	}
	
}
