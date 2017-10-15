package Backend;

import java.io.Serializable;
import java.util.HashMap;

public class Course implements Serializable {
	private Timetable time;
	private Room[] rooms = new Room[6];
	private Faculty fac;
	private HashMap<String, Student> students = new HashMap<>();
	private HashMap<Integer,String > prereqs = new HashMap<>();
	private static int prereq_count=0;
	private static int post_count =0;
	private HashMap<Integer , String> post = new HashMap<>();
	
	public Course(Timetable t , Room[] r , Faculty f ) {
		time = t;
		rooms = r;
		fac =f;
	}
}
