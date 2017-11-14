package Backend;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Student extends User implements Comparable {
	private Timetable s_table = new Timetable(new boolean[6][20]) ;
	static int num_course =0;
	private HashMap<Integer , Request > requests = new HashMap<>();
	private HashMap<String , Course > courses = new HashMap<>();
	
	
	public Student(String n , String e , String p ) {
		super(n,e,p);
	}
	
	public int compareTo(Object t) {
		Student s = (Student)t;
		if(this.getName().equals(s.getName()) && (this.getEmail().equals(s.getEmail())) && this.password.equals(s.password)) {
			return 1;
		}
		else return 0;
	}
	
	public void serialise() throws FileNotFoundException, IOException {
		ObjectOutputStream out=null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("./src/Database/students/"+this.getName()+".txt"));
			out.writeObject(this);
		}
		finally {
			out.close();
		}
	}
	
	public static Student deserialise(String x) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in =null;
		Student s1;
		try {
			in = new ObjectInputStream(new FileInputStream(x));
		    s1 = (Student)in.readObject();
			
		}
		finally
		{
			//in.close();
			}
		return s1;
	}

	public void setTable(Timetable t) {
		s_table = t;
	}
	
	public Timetable getTable() {
		return s_table;
	}
	
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
	}
	public HashMap<Integer , Request > getRequests() {
		return requests;
	}
	public void setRequests(HashMap<Integer , Request > requests) {
		this.requests = requests;
	}
	public HashMap<String , Course > getCourses() {
		return courses;
	}
	public void setCourses(HashMap<String , Course > courses) {
		this.courses = courses;
	}
}
