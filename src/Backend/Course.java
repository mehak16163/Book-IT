package Backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class Course implements Serializable {
	private String name;
	private String nature;
	private String acro;
	private String code;
	private Timetable time;
	private Room[] rooms = new Room[6];
	private Faculty fac;
	private HashMap<String, Student> students = new HashMap<>();
	private HashMap<Integer,String > prereqs = new HashMap<>();
	private static int prereq_count=0;
	private static int post_count =0;
	private HashMap<Integer , String> post = new HashMap<>();
	
	public Course(String na,String n , String a,String c ,Timetable t , Room[] r , Faculty f ) {
		code =c;
		time = t;
		rooms = r;
		fac =f;
		nature =n;
		acro =a;
		name = na;
	}
	
	public void serialise() throws FileNotFoundException, IOException {
		ObjectOutputStream out=null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("./src/Database/courses/"+this.name+".txt"));
			out.writeObject(this);
		}
		finally {
			out.close();
		}
	}
	
	public static Course deserialise(String x) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in =null;
		Course s1;
		try {
			in = new ObjectInputStream(new FileInputStream(x));
		    s1 = (Course)in.readObject();
			
		}
		finally
		{
			in.close();
			}
		return s1;
	}

}
