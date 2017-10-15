package Backend;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Student extends User implements Comparable {
	private Timetable s_table ;
	static int num_course =0;
	private HashMap<Integer , Request > requests = new HashMap<>();
	private HashMap<String , Course > courses = new HashMap<>();
	
	public Student(String n , String e , String p ,Timetable t) {
		super(n,e,p);
		s_table = t;
	}
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
	
	public void setTable(Timetable t) {
		s_table = t;
	}
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		ObjectOutputStream out=null ;
		String name = rd.readLine();
		String email = rd.readLine();
		String pass = rd.readLine();
		//File f = new File("./src/Database/"+name+".txt");
		Boolean[][] t = new Boolean[6][90] ;
		Timetable table = new Timetable(t);
		Student s = new Student(name , email , pass ,table );
		out  = new ObjectOutputStream(new FileOutputStream("./src/Database/students/"+name+".txt"));
		out.writeObject(s);
		out.close();
	}
}
