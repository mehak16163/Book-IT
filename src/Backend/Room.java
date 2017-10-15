package Backend;

import java.io.Serializable;

public class Room implements Serializable{
	private Timetable bookings;
	private int capacity;
	public int getCapacity() {
		return capacity;
	}
	public Room(Timetable t , int c) {
		bookings = t;
		capacity =c;
	}
	
}
